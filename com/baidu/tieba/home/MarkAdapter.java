package com.baidu.tieba.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.data.MarkData;
import com.baidu.tieba.util.TiebaLog;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class MarkAdapter extends BaseAdapter {
    private boolean displayNull;
    private Context mContext;
    private ArrayList<MarkData> mData;
    private boolean mIsNodata;
    private int mSize;

    public MarkAdapter(Context context, ArrayList<MarkData> data) {
        this.mContext = context;
        this.mData = data;
        setDisplayNull(true);
        checkNodata();
    }

    public void checkNodata() {
        this.mIsNodata = false;
        if (this.mData == null) {
            this.mSize = 0;
            return;
        }
        int size = this.mData.size();
        if (size == 0) {
            if (this.displayNull) {
                this.mSize = 1;
                this.mIsNodata = true;
                return;
            }
            this.mSize = 0;
            return;
        }
        this.mSize = size;
    }

    public void setData(ArrayList<MarkData> data) {
        this.mData = data;
        checkNodata();
    }

    public ArrayList<MarkData> getData() {
        return this.mData;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.mSize;
    }

    @Override // android.widget.Adapter
    public Object getItem(int position) {
        int count;
        if (this.mIsNodata || (count = getCount()) <= 0 || position >= count) {
            return null;
        }
        Object item = this.mData.get(position);
        return item;
    }

    @Override // android.widget.Adapter
    public long getItemId(int position) {
        Object item;
        if (this.mIsNodata || (item = getItem(position)) == null) {
            return 0L;
        }
        MarkData data = (MarkData) item;
        return Integer.parseInt(data.getId());
    }

    @Override // android.widget.Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        Object obData;
        try {
            if (convertView == null) {
                LayoutInflater mInflater = LayoutInflater.from(this.mContext);
                convertView = mInflater.inflate(R.layout.home_mark_item, (ViewGroup) null);
                ViewHolder holder2 = new ViewHolder(this, null);
                try {
                    holder2.mReplyNum = (TextView) convertView.findViewById(R.id.home_lv_markitem_reply);
                    holder2.mContent = (LinearLayout) convertView.findViewById(R.id.home_lv_markitem_content);
                    holder2.mTitle = (TextView) convertView.findViewById(R.id.home_lv_markitem_title);
                    holder2.mAuthor = (TextView) convertView.findViewById(R.id.home_lv_markitem_author);
                    holder2.mNodata = (TextView) convertView.findViewById(R.id.forum_lv_nodata);
                    convertView.setTag(holder2);
                    holder = holder2;
                } catch (Exception e) {
                    ex = e;
                    TiebaLog.e(getClass().getName(), "", "MarkAdapter.getView error = " + ex.getMessage());
                    return convertView;
                }
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            if (this.mIsNodata) {
                holder.mReplyNum.setVisibility(8);
                holder.mContent.setVisibility(8);
                holder.mNodata.setVisibility(0);
            } else {
                holder.mReplyNum.setVisibility(0);
                holder.mContent.setVisibility(0);
                holder.mNodata.setVisibility(8);
            }
            obData = getItem(position);
        } catch (Exception e2) {
            ex = e2;
        }
        if (obData == null) {
            return convertView;
        }
        MarkData data = (MarkData) obData;
        int replyNum = data.getReplyNum();
        if (replyNum <= 999) {
            holder.mReplyNum.setText(String.valueOf(replyNum));
        } else {
            holder.mReplyNum.setText("999+");
        }
        holder.mTitle.setText(data.getTitle());
        holder.mAuthor.setText(data.getAuthorName());
        return convertView;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int position) {
        if (this.mIsNodata) {
            return false;
        }
        return super.isEnabled(position);
    }

    public void setDisplayNull(boolean displayNull) {
        this.displayNull = displayNull;
    }

    public boolean isDisplayNull() {
        return this.displayNull;
    }

    /* loaded from: classes.dex */
    private class ViewHolder {
        TextView mAuthor;
        LinearLayout mContent;
        TextView mNodata;
        TextView mReplyNum;
        TextView mTitle;

        private ViewHolder() {
        }

        /* synthetic */ ViewHolder(MarkAdapter markAdapter, ViewHolder viewHolder) {
            this();
        }
    }
}
