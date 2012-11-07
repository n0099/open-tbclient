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
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.data.ForumData;
import com.baidu.tieba.util.BitmapHelper;
import com.baidu.tieba.util.TiebaLog;
import com.baidu.tieba.util.UtilHelper;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class LikeAdapter extends BaseAdapter {
    private static final int TYPE_BAR = 1;
    private static final int TYPE_NODATA = 0;
    private Context mContext;
    private ArrayList<ForumData> mData;
    private String mGrade;
    private int mMargin;
    private View.OnClickListener mForumListener = null;
    private View.OnLongClickListener mForumLongListener = null;
    private ArrayList<ProgressBar> mProgressbars = new ArrayList<>();

    public LikeAdapter(Context context, ArrayList<ForumData> data) {
        this.mMargin = 10;
        this.mContext = context;
        this.mData = data;
        this.mGrade = this.mContext.getText(R.string.grade).toString();
        this.mMargin = UtilHelper.dip2px(this.mContext, 10.0f);
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

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.mData == null) {
            return 0;
        }
        int size = this.mData.size();
        int num = (size / 2) + (size % 2);
        if (num == 0) {
            return num + 1;
        }
        return num;
    }

    @Override // android.widget.Adapter
    public Object getItem(int position) {
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int position) {
        return position;
    }

    @Override // android.widget.Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        try {
            int type = getItemViewType(position);
            if (convertView == null) {
                LayoutInflater mInflater = LayoutInflater.from(this.mContext);
                if (type == 1) {
                    convertView = mInflater.inflate(R.layout.home_like_item, (ViewGroup) null);
                    ViewHolder holder2 = new ViewHolder(this, null);
                    try {
                        holder2.mItem = (LinearLayout) convertView;
                        holder2.mForum = (LinearLayout) convertView.findViewById(R.id.first);
                        holder2.mForum.setOnClickListener(this.mForumListener);
                        holder2.mForum.setOnLongClickListener(this.mForumLongListener);
                        holder2.mForumName = (TextView) convertView.findViewById(R.id.home_lv_like_forum1);
                        holder2.mGradeImage = (ImageView) convertView.findViewById(R.id.home_lv_like_gimg1);
                        holder2.mForumGrade = (TextView) convertView.findViewById(R.id.forum_lv_like_grade1);
                        holder2.mSecond = new ViewHolder(this, null);
                        holder2.mSecond.mForum = (LinearLayout) convertView.findViewById(R.id.second);
                        holder2.mSecond.mForum.setOnClickListener(this.mForumListener);
                        holder2.mSecond.mForum.setOnLongClickListener(this.mForumLongListener);
                        holder2.mSecond.mForumName = (TextView) convertView.findViewById(R.id.home_lv_like_forum2);
                        holder2.mSecond.mGradeImage = (ImageView) convertView.findViewById(R.id.home_lv_like_gimg2);
                        holder2.mSecond.mForumGrade = (TextView) convertView.findViewById(R.id.forum_lv_like_grade2);
                        convertView.setTag(holder2);
                        holder = holder2;
                    } catch (Exception e) {
                        ex = e;
                        TiebaLog.e(getClass().getName(), "getView", ex.getMessage());
                        return convertView;
                    }
                } else if (type == 0) {
                    return mInflater.inflate(R.layout.home_like_nodata_item, (ViewGroup) null);
                }
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            if (holder != null) {
                if (position == 0) {
                    holder.mItem.setPadding(0, this.mMargin, 0, this.mMargin);
                } else {
                    holder.mItem.setPadding(0, 0, 0, this.mMargin);
                }
            }
            if (type == 1 && holder != null) {
                if (position >= 0) {
                    ForumData first = this.mData.get(position * 2);
                    updateUI(first, holder);
                }
                if ((position * 2) + 1 < this.mData.size()) {
                    holder.mSecond.mForum.setVisibility(0);
                    ForumData second = this.mData.get((position * 2) + 1);
                    updateUI(second, holder.mSecond);
                } else {
                    holder.mSecond.mForum.setVisibility(4);
                }
            }
        } catch (Exception e2) {
            ex = e2;
        }
        return convertView;
    }

    private void updateUI(ForumData data, ViewHolder holder) {
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
        return (this.mData == null || this.mData.size() <= 0) ? 0 : 1;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int position) {
        return getItemViewType(position) != 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
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
        LinearLayout mForum;
        TextView mForumGrade;
        TextView mForumName;
        ImageView mGradeImage;
        LinearLayout mItem;
        ViewHolder mSecond;

        private ViewHolder() {
        }

        /* synthetic */ ViewHolder(LikeAdapter likeAdapter, ViewHolder viewHolder) {
            this();
        }
    }
}
