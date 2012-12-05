package com.baidu.tieba.home;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.LikeForumData;
import com.baidu.tieba.model.LikeForumModel;
import com.baidu.tieba.util.BitmapHelper;
import com.baidu.tieba.util.TiebaLog;
import com.baidu.tieba.util.UtilHelper;
import java.text.MessageFormat;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class EnterForumAdapter extends BaseAdapter {
    private static final int MAX_LIKE_SHOWED = 8;
    public static final int TYPE_ENTER_FORUM = 0;
    public static final int TYPE_GOON_LIKE_BUTTON = 6;
    public static final int TYPE_LIKE_FORUM = 5;
    public static final int TYPE_LIKE_NODATA = 4;
    public static final int TYPE_LOGIN_BLOCK = 1;
    public static final int TYPE_RECOMMEND_FORUM = 3;
    public static final int TYPE_RECOMMEND_TIP = 2;
    private Context mContext;
    private View.OnClickListener mForumListener;
    private View.OnLongClickListener mForumLongListener;
    private String mGrade;
    private Boolean mHasShowedMoreLike;
    private View.OnClickListener mLikeForumListener;
    private int mMargin;
    private ArrayList<ProgressBar> mProgressbars;
    private View.OnClickListener mWantLoginListener;
    private LikeForumModel mModel = null;
    private Boolean mIsLogin = false;
    private Boolean mIsRefresh = true;
    private Boolean mHasMoreLike = false;

    public EnterForumAdapter(Context context, LikeForumModel data) {
        this.mHasShowedMoreLike = false;
        this.mMargin = 10;
        this.mContext = context;
        setData(data);
        this.mGrade = this.mContext.getText(R.string.grade).toString();
        this.mForumListener = null;
        this.mForumLongListener = null;
        this.mWantLoginListener = null;
        this.mLikeForumListener = null;
        this.mMargin = UtilHelper.dip2px(this.mContext, 10.0f);
        this.mProgressbars = new ArrayList<>();
        this.mHasShowedMoreLike = Boolean.valueOf(TiebaApplication.app.getShowAllLikeItems() != null);
    }

    public void releaseProgressBar() {
        if (this.mProgressbars != null) {
            for (int i = 0; i < this.mProgressbars.size(); i++) {
                try {
                    this.mProgressbars.get(i).setVisibility(8);
                } catch (Exception ex) {
                    TiebaLog.e(getClass().getName(), "releaseProgressBar", ex.getMessage());
                }
            }
            this.mProgressbars.clear();
        }
    }

    public void setData(LikeForumModel data) {
        this.mModel = data;
        if (data != null && data.getLike_Forums() != null && data.getLike_Forums().size() > 8) {
            this.mHasMoreLike = true;
        } else {
            this.mHasMoreLike = false;
        }
        if (data != null) {
            if (data.getRecommend_Forums() == null || data.getRecommend_Forums().size() == 0) {
                this.mHasShowedMoreLike = true;
            }
        }
    }

    public LikeForumModel getData() {
        return this.mModel;
    }

    public void setLoginState(Boolean isLogin) {
        this.mIsLogin = isLogin;
        this.mIsRefresh = false;
    }

    public void setHasShowedMoreLike() {
        this.mHasShowedMoreLike = true;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int num;
        if (this.mModel == null) {
            return 1;
        }
        if (this.mIsLogin.booleanValue()) {
            if (this.mModel.getLike_Forums() != null && this.mModel.getLike_Forums().size() > 0) {
                int size = this.mModel.getLike_Forums().size();
                if (size <= 8) {
                    int num2 = 1 + (size / 2);
                    num = num2 + (size % 2);
                } else if (this.mHasShowedMoreLike.booleanValue()) {
                    int num3 = 1 + (size / 2);
                    num = num3 + (size % 2);
                } else {
                    int num4 = 1 + 4;
                    num = num4 + 1;
                }
            } else {
                num = 1 + 1;
            }
        } else {
            num = 1 + 1;
        }
        if (this.mModel.getRecommend_Forums() != null && this.mModel.getRecommend_Forums().size() > 0) {
            num = num + this.mModel.getRecommend_Forums().size() + 1;
        }
        return num;
    }

    @Override // android.widget.Adapter
    public Object getItem(int position) {
        int type = getItemViewType(position);
        if (type == 3) {
            int recommendStartIndex = getRecommendStartPosition();
            int recommendOffset = position - recommendStartIndex;
            if (this.mModel != null && this.mModel.getRecommend_Forums() != null && recommendOffset >= 0 && this.mModel.getRecommend_Forums().size() > recommendOffset) {
                return this.mModel.getRecommend_Forums().get(recommendOffset);
            }
        }
        return Integer.valueOf(type);
    }

    public int getRecommendStartPosition() {
        if (this.mModel != null && this.mModel.getRecommend_Forums() != null) {
            if (this.mModel.getRecommend_Forums().size() == 0) {
                return (getCount() - this.mModel.getRecommend_Forums().size()) - 1;
            }
            return getCount() - this.mModel.getRecommend_Forums().size();
        }
        return 3;
    }

    @Override // android.widget.Adapter
    public long getItemId(int position) {
        return position;
    }

    @Override // android.widget.Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolderLike holderLike = null;
        ViewHolderRecommend holderRecommend = null;
        try {
            int type = getItemViewType(position);
            if (convertView == null) {
                LayoutInflater mInflater = LayoutInflater.from(this.mContext);
                if (type == 0) {
                    return mInflater.inflate(R.layout.enter_forum_enter, (ViewGroup) null);
                }
                if (type == 1) {
                    View convertView2 = mInflater.inflate(R.layout.enter_forum_login, (ViewGroup) null);
                    Button buttonWantLogin = (Button) convertView2.findViewById(R.id.want_login);
                    buttonWantLogin.setOnClickListener(this.mWantLoginListener);
                    if (this.mIsRefresh.booleanValue()) {
                        convertView2.setVisibility(4);
                    } else {
                        convertView2.setVisibility(0);
                    }
                    return convertView2;
                } else if (type == 2) {
                    return mInflater.inflate(R.layout.enter_forum_recommend_tip, (ViewGroup) null);
                } else {
                    if (type == 4) {
                        return mInflater.inflate(R.layout.home_like_nodata_item, (ViewGroup) null);
                    }
                    if (type == 6) {
                        return mInflater.inflate(R.layout.enter_forum_goon_show_like, (ViewGroup) null);
                    }
                    if (type == 3) {
                        convertView = mInflater.inflate(R.layout.enter_forum_recommand_item, (ViewGroup) null);
                        ViewHolderRecommend holderRecommend2 = new ViewHolderRecommend(this, null);
                        try {
                            holderRecommend2.mItem = (RelativeLayout) convertView;
                            holderRecommend2.mRecommendForumName = (TextView) convertView.findViewById(R.id.recommend_forum_name);
                            holderRecommend2.mMemberCount = (TextView) convertView.findViewById(R.id.member_count);
                            holderRecommend2.mForumAbstract = (TextView) convertView.findViewById(R.id.forum_abstract);
                            holderRecommend2.mRecommendLike = (ImageView) convertView.findViewById(R.id.recommend_like);
                            holderRecommend2.mRecommendLike.setOnClickListener(this.mLikeForumListener);
                            convertView.setTag(holderRecommend2);
                            holderRecommend = holderRecommend2;
                        } catch (Exception e) {
                            ex = e;
                            TiebaLog.e(getClass().getName(), "getView", ex.getMessage());
                            return convertView;
                        }
                    } else if (type == 5) {
                        convertView = mInflater.inflate(R.layout.home_like_item, (ViewGroup) null);
                        ViewHolderLike holderLike2 = new ViewHolderLike(this, null);
                        try {
                            holderLike2.mItem = (LinearLayout) convertView;
                            holderLike2.mForum = (LinearLayout) convertView.findViewById(R.id.first);
                            holderLike2.mForum.setOnClickListener(this.mForumListener);
                            holderLike2.mForum.setOnLongClickListener(this.mForumLongListener);
                            holderLike2.mForumName = (TextView) convertView.findViewById(R.id.home_lv_like_forum1);
                            holderLike2.mGradeImage = (ImageView) convertView.findViewById(R.id.home_lv_like_gimg1);
                            holderLike2.mForumGrade = (TextView) convertView.findViewById(R.id.forum_lv_like_grade1);
                            holderLike2.mSecond = new ViewHolderLike(this, null);
                            holderLike2.mSecond.mForum = (LinearLayout) convertView.findViewById(R.id.second);
                            holderLike2.mSecond.mForum.setOnClickListener(this.mForumListener);
                            holderLike2.mSecond.mForum.setOnLongClickListener(this.mForumLongListener);
                            holderLike2.mSecond.mForumName = (TextView) convertView.findViewById(R.id.home_lv_like_forum2);
                            holderLike2.mSecond.mGradeImage = (ImageView) convertView.findViewById(R.id.home_lv_like_gimg2);
                            holderLike2.mSecond.mForumGrade = (TextView) convertView.findViewById(R.id.forum_lv_like_grade2);
                            convertView.setTag(holderLike2);
                            holderLike = holderLike2;
                        } catch (Exception e2) {
                            ex = e2;
                            TiebaLog.e(getClass().getName(), "getView", ex.getMessage());
                            return convertView;
                        }
                    }
                }
            } else {
                if (type == 3) {
                    holderRecommend = (ViewHolderRecommend) convertView.getTag();
                }
                if (type == 5) {
                    holderLike = (ViewHolderLike) convertView.getTag();
                }
            }
            Resources rs = this.mContext.getResources();
            if (type == 3 && holderRecommend != null && this.mModel.getRecommend_Forums() != null) {
                Object oriData = getItem(position);
                LikeForumData data = null;
                if (oriData != null && (oriData instanceof LikeForumData)) {
                    data = (LikeForumData) oriData;
                }
                if (data != null) {
                    holderRecommend.mRecommendForumName.setText(String.valueOf(data.getName()) + rs.getString(R.string.forum));
                    holderRecommend.mMemberCount.setText(MessageFormat.format(rs.getString(R.string.forum_like_memeber), Integer.valueOf(data.getMember_num())));
                    holderRecommend.mForumAbstract.setText(data.getDesc());
                    holderRecommend.mRecommendLike.setVisibility(this.mIsLogin.booleanValue() ? 0 : 4);
                    holderRecommend.mItem.setVisibility(0);
                    holderRecommend.mRecommendLike.setTag(data);
                } else {
                    holderRecommend.mItem.setVisibility(4);
                }
            }
            if (type == 5 && holderLike != null && this.mModel.getLike_Forums() != null) {
                if (position == 1) {
                    holderLike.mItem.setPadding(0, this.mMargin, 0, this.mMargin);
                } else {
                    holderLike.mItem.setPadding(0, 0, 0, this.mMargin);
                }
                if (position >= 1) {
                    if ((position - 1) * 2 < this.mModel.getLike_Forums().size()) {
                        LikeForumData first = this.mModel.getLike_Forums().get((position - 1) * 2);
                        updateUI(first, holderLike);
                    }
                    if (((position - 1) * 2) + 1 < this.mModel.getLike_Forums().size()) {
                        holderLike.mSecond.mForum.setVisibility(0);
                        LikeForumData second = this.mModel.getLike_Forums().get(((position - 1) * 2) + 1);
                        updateUI(second, holderLike.mSecond);
                    } else {
                        holderLike.mSecond.mForum.setVisibility(4);
                    }
                }
            }
        } catch (Exception e3) {
            ex = e3;
        }
        return convertView;
    }

    private void updateUI(LikeForumData data, ViewHolderLike holder) {
        if (data != null && holder != null) {
            int grade = data.getUser_level();
            holder.mForum.setTag(data);
            holder.mForumName.setText(data.getName());
            if (grade == 0 || data.isIs_like() == 0) {
                holder.mGradeImage.setVisibility(8);
                holder.mForumGrade.setVisibility(8);
                return;
            }
            holder.mGradeImage.setVisibility(0);
            holder.mForumGrade.setVisibility(0);
            if (1 <= grade && grade <= 3) {
                Bitmap bm = BitmapHelper.getCashBitmap(R.drawable.home_grade_1);
                holder.mGradeImage.setImageBitmap(bm);
            } else if (4 <= grade && grade <= 9) {
                Bitmap bm2 = BitmapHelper.getCashBitmap(R.drawable.home_grade_2);
                holder.mGradeImage.setImageBitmap(bm2);
            } else if (10 <= grade && grade <= 15) {
                Bitmap bm3 = BitmapHelper.getCashBitmap(R.drawable.home_grade_3);
                holder.mGradeImage.setImageBitmap(bm3);
            } else {
                Bitmap bm4 = BitmapHelper.getCashBitmap(R.drawable.home_grade_4);
                holder.mGradeImage.setImageBitmap(bm4);
            }
            holder.mForumGrade.setText(String.valueOf(data.getUser_level()).concat(this.mGrade));
        }
    }

    private int getLikeItemViewType(int position) {
        if (!this.mIsLogin.booleanValue()) {
            return 1;
        }
        if (this.mModel == null || this.mModel.getLike_Forums() == null || this.mModel.getLike_Forums().size() == 0) {
            return 4;
        }
        return (position == 5 && this.mHasMoreLike.booleanValue() && !this.mHasShowedMoreLike.booleanValue()) ? 6 : 5;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int position) {
        int recommendStartIndex = getRecommendStartPosition();
        if (position == 0) {
            return 0;
        }
        if (this.mModel != null && this.mModel.getRecommend_Forums() != null && this.mModel.getRecommend_Forums().size() > 0) {
            if (position == recommendStartIndex - 1) {
                return 2;
            }
            if (position >= recommendStartIndex) {
                return 3;
            }
        }
        return getLikeItemViewType(position);
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int position) {
        return getItemViewType(position) == 3 || getItemViewType(position) == 6 || getItemViewType(position) == 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 7;
    }

    public void setForumOnClickListener(View.OnClickListener forumListener) {
        this.mForumListener = forumListener;
    }

    public void setForumOnLongClickListener(View.OnLongClickListener forumLongListener) {
        this.mForumLongListener = forumLongListener;
    }

    public void setWantLoginClickListener(View.OnClickListener wantLoginListener) {
        this.mWantLoginListener = wantLoginListener;
    }

    public void setLikeForumClickListener(View.OnClickListener likeForumListener) {
        this.mLikeForumListener = likeForumListener;
    }

    /* loaded from: classes.dex */
    private class ViewHolderRecommend {
        TextView mForumAbstract;
        RelativeLayout mItem;
        TextView mMemberCount;
        TextView mRecommendForumName;
        ImageView mRecommendLike;

        private ViewHolderRecommend() {
        }

        /* synthetic */ ViewHolderRecommend(EnterForumAdapter enterForumAdapter, ViewHolderRecommend viewHolderRecommend) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class ViewHolderLike {
        LinearLayout mForum;
        TextView mForumGrade;
        TextView mForumName;
        ImageView mGradeImage;
        LinearLayout mItem;
        ViewHolderLike mSecond;

        private ViewHolderLike() {
        }

        /* synthetic */ ViewHolderLike(EnterForumAdapter enterForumAdapter, ViewHolderLike viewHolderLike) {
            this();
        }
    }
}
