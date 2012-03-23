package com.baidu.tieba.home;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.data.ForumData;
import com.baidu.tieba.util.BitmapHelper;
import com.baidu.tieba.util.TiebaLog;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class LikeAdapter extends BaseAdapter {
    private static final int TYPE_BAR = 1;
    private static final int TYPE_FOOTER = 3;
    private static final int TYPE_HEADER = 2;
    private static final int TYPE_NODATA = 0;
    private Context mContext;
    private ArrayList<ForumData> mData;
    private String mGrade;
    private View.OnClickListener mHeaderListener;
    private boolean mIsFooterRefresh = false;
    private String mUpdateTime = null;
    private View.OnClickListener mForumListener = null;
    private View.OnLongClickListener mForumLongListener = null;
    private ArrayList<ProgressBar> mProgressbars = new ArrayList<>();

    public LikeAdapter(Context context, ArrayList<ForumData> data) {
        this.mContext = context;
        this.mData = data;
        this.mGrade = this.mContext.getText(R.string.grade).toString();
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

    public void setData(ArrayList<ForumData> data) {
        this.mData = data;
    }

    public ArrayList<ForumData> getData() {
        return this.mData;
    }

    public void setIsRefresh(boolean refresh) {
        this.mIsFooterRefresh = refresh;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int num = 0;
        if (this.mData != null) {
            int size = this.mData.size();
            int num2 = size / 2;
            num = num2 + (size % 2);
            if (num == 0) {
                num++;
            }
        }
        return 2 + num;
    }

    @Override // android.widget.Adapter
    public Object getItem(int position) {
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int position) {
        return position;
    }

    private void initElement(ViewHolder holder, View parent) {
        holder.mForumName = (TextView) parent.findViewById(R.id.home_lv_like_forum);
        holder.mGradeImage = (ImageView) parent.findViewById(R.id.home_lv_like_gimg);
        holder.mForumGrade = (TextView) parent.findViewById(R.id.forum_lv_like_grade);
    }

    @Override // android.widget.Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        ViewHolder holder2 = null;
        try {
            int type = getItemViewType(position);
            if (convertView == null) {
                LayoutInflater mInflater = LayoutInflater.from(this.mContext);
                try {
                    if (type == 1) {
                        convertView = mInflater.inflate(R.layout.home_like_item, (ViewGroup) null);
                        holder = new ViewHolder(this, null);
                        holder.mForum = (LinearLayout) convertView.findViewById(R.id.first);
                        holder.mForum.setOnClickListener(this.mForumListener);
                        holder.mForum.setOnLongClickListener(this.mForumLongListener);
                        initElement(holder, holder.mForum);
                        holder.mSecond = new ViewHolder(this, null);
                        holder.mSecond.mForum = (LinearLayout) convertView.findViewById(R.id.second);
                        holder.mSecond.mForum.setOnClickListener(this.mForumListener);
                        holder.mSecond.mForum.setOnLongClickListener(this.mForumLongListener);
                        initElement(holder.mSecond, holder.mSecond.mForum);
                        convertView.setTag(holder);
                        holder2 = holder;
                    } else if (type == 0) {
                        convertView = mInflater.inflate(R.layout.home_like_nodata_item, (ViewGroup) null);
                    } else if (type == 2) {
                        convertView = mInflater.inflate(R.layout.home_like_header, (ViewGroup) null);
                        convertView.setOnClickListener(this.mHeaderListener);
                    } else if (type == 3) {
                        convertView = mInflater.inflate(R.layout.home_like_footer, (ViewGroup) null);
                        holder = new ViewHolder(this, null);
                        holder.mFooter = new FooterView(this, null);
                        holder.mFooter.mIsLoading = (RelativeLayout) convertView.findViewById(R.id.home_like_loading);
                        holder.mFooter.mRefresh = (LinearLayout) convertView.findViewById(R.id.home_like_refresh);
                        holder.mFooter.mTextUptime = (TextView) convertView.findViewById(R.id.home_like_tv_uptime);
                        holder.mFooter.mProgressRefresh = (ProgressBar) convertView.findViewById(R.id.home_like_progress_refresh);
                        this.mProgressbars.add(holder.mFooter.mProgressRefresh);
                        convertView.setTag(holder);
                        holder2 = holder;
                    }
                } catch (Exception e) {
                    ex = e;
                    TiebaLog.e(getClass().getName(), "getView", ex.getMessage());
                    return convertView;
                }
            } else {
                holder2 = (ViewHolder) convertView.getTag();
            }
            if (type == 1 && holder2 != null) {
                int index = position - 1;
                if (index >= 0) {
                    ForumData first = this.mData.get(index * 2);
                    updateUI(first, holder2);
                }
                if ((index * 2) + 1 < this.mData.size()) {
                    holder2.mSecond.mForum.setVisibility(0);
                    ForumData second = this.mData.get((index * 2) + 1);
                    updateUI(second, holder2.mSecond);
                } else {
                    holder2.mSecond.mForum.setVisibility(4);
                }
            } else if (type == 3 && holder2 != null) {
                if (this.mIsFooterRefresh) {
                    holder2.mFooter.mIsLoading.setVisibility(0);
                    holder2.mFooter.mRefresh.setVisibility(4);
                } else {
                    holder2.mFooter.mIsLoading.setVisibility(8);
                    holder2.mFooter.mRefresh.setVisibility(0);
                    holder2.mFooter.mTextUptime.setText(this.mUpdateTime);
                }
            }
        } catch (Exception e2) {
            ex = e2;
        }
        return convertView;
    }

    public void setUpdateTime(String time) {
        this.mUpdateTime = time;
        notifyDataSetChanged();
    }

    private void updateUI(ForumData data, ViewHolder holder) throws Exception {
        if (data != null && holder != null) {
            int grade = data.getUser_level();
            holder.mForum.setTag(data);
            holder.mForumName.setText(data.getName());
            if (grade < 1) {
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

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int position) {
        if (position == 0) {
            return 2;
        }
        if (position == getCount() - 1) {
            return 3;
        }
        if (this.mData != null && this.mData.size() > 0) {
            return 1;
        }
        return 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int position) {
        return getItemViewType(position) != 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 4;
    }

    public void setHeaderOnClickListener(View.OnClickListener headerListener) {
        this.mHeaderListener = headerListener;
    }

    public void setForumOnClickListener(View.OnClickListener forumListener) {
        this.mForumListener = forumListener;
    }

    public void setForumOnLongClickListener(View.OnLongClickListener forumLongListener) {
        this.mForumLongListener = forumLongListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class ViewHolder {
        FooterView mFooter;
        LinearLayout mForum;
        TextView mForumGrade;
        TextView mForumName;
        ImageView mGradeImage;
        ViewHolder mSecond;

        private ViewHolder() {
        }

        /* synthetic */ ViewHolder(LikeAdapter likeAdapter, ViewHolder viewHolder) {
            this();
        }
    }

    /* loaded from: classes.dex */
    private class FooterView {
        RelativeLayout mIsLoading;
        ProgressBar mProgressRefresh;
        LinearLayout mRefresh;
        TextView mTextUptime;

        private FooterView() {
        }

        /* synthetic */ FooterView(LikeAdapter likeAdapter, FooterView footerView) {
            this();
        }
    }
}
