package com.baidu.tieba.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.data.ForumData;
import com.baidu.tieba.util.TiebaLog;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class LikeAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<ForumData> mData;
    private String mForum;
    private String mGrade;
    private boolean mIsNodata;
    private int mSize;

    public LikeAdapter(Context context, ArrayList<ForumData> data) {
        this.mContext = context;
        this.mData = data;
        this.mForum = this.mContext.getText(R.string.forum).toString();
        this.mGrade = this.mContext.getText(R.string.grade).toString();
        checkNodata();
    }

    private void checkNodata() {
        this.mIsNodata = false;
        if (this.mData == null) {
            this.mSize = 0;
            return;
        }
        int size = this.mData.size();
        if (size == 0) {
            this.mSize = 1;
            this.mIsNodata = true;
            return;
        }
        this.mSize = size;
    }

    public void setData(ArrayList<ForumData> data) {
        this.mData = data;
        checkNodata();
    }

    public ArrayList<ForumData> getData() {
        return this.mData;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.mSize;
    }

    @Override // android.widget.Adapter
    public Object getItem(int position) {
        if (this.mIsNodata) {
            return null;
        }
        Object item = null;
        int count = getCount();
        if (count > 0 && position < count) {
            item = this.mData.get(position);
        }
        return item;
    }

    @Override // android.widget.Adapter
    public long getItemId(int position) {
        return position;
    }

    @Override // android.widget.Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        Exception ex;
        ViewHolder holder;
        Object obData;
        try {
            if (convertView == null) {
                LayoutInflater mInflater = LayoutInflater.from(this.mContext);
                convertView = mInflater.inflate(R.layout.home_like_item, (ViewGroup) null);
                ViewHolder holder2 = new ViewHolder();
                try {
                    holder2.mForumName = (TextView) convertView.findViewById(R.id.home_lv_like_forum);
                    holder2.mGradeImage = (ImageView) convertView.findViewById(R.id.home_lv_like_gimg);
                    holder2.mForumGrade = (TextView) convertView.findViewById(R.id.forum_lv_like_grade);
                    holder2.mNodata = (TextView) convertView.findViewById(R.id.forum_lv_nodata);
                    convertView.setTag(holder2);
                    holder = holder2;
                } catch (Exception e) {
                    ex = e;
                    TiebaLog.e(getClass().getName(), "", "PbAdapter.getView error = " + ex.getMessage());
                    return convertView;
                }
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            if (this.mIsNodata) {
                holder.mForumName.setVisibility(8);
                holder.mGradeImage.setVisibility(8);
                holder.mForumGrade.setVisibility(8);
                holder.mNodata.setVisibility(0);
            } else {
                holder.mForumName.setVisibility(0);
                holder.mGradeImage.setVisibility(0);
                holder.mForumGrade.setVisibility(0);
                holder.mNodata.setVisibility(8);
            }
            obData = getItem(position);
        } catch (Exception e2) {
            ex = e2;
        }
        if (obData == null) {
            return convertView;
        }
        ForumData data = (ForumData) obData;
        int grade = data.getUser_level();
        holder.mForumName.setText(data.getName().concat(this.mForum));
        if (grade < 1) {
            holder.mGradeImage.setVisibility(4);
            holder.mForumGrade.setVisibility(4);
        } else {
            holder.mGradeImage.setVisibility(0);
            holder.mForumGrade.setVisibility(0);
            if (1 <= grade && grade <= 3) {
                holder.mGradeImage.setImageResource(R.drawable.home_grade_1);
            } else if (4 <= grade && grade <= 9) {
                holder.mGradeImage.setImageResource(R.drawable.home_grade_2);
            } else if (10 <= grade && grade <= 15) {
                holder.mGradeImage.setImageResource(R.drawable.home_grade_3);
            } else {
                holder.mGradeImage.setImageResource(R.drawable.home_grade_4);
            }
            holder.mForumGrade.setText(String.valueOf(data.getUser_level()).concat(this.mGrade));
        }
        return convertView;
    }

    /* loaded from: classes.dex */
    private class ViewHolder {
        TextView mForumGrade;
        TextView mForumName;
        ImageView mGradeImage;
        TextView mNodata;

        private ViewHolder() {
        }
    }
}
