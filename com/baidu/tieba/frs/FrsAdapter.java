package com.baidu.tieba.frs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.data.ThreadData;
import com.baidu.tieba.util.StringHelper;
import com.baidu.tieba.util.TiebaLog;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes.dex */
public class FrsAdapter extends BaseAdapter {
    Context mContext;
    ArrayList<ThreadData> mData;
    private boolean mHaveFooter;
    private boolean mHaveHeader;
    private int mHeaderType;
    private boolean mIsProcessNext;
    private boolean mIsProcessPre;
    private ArrayList<ProgressBar> mProgressbars = new ArrayList<>();

    public FrsAdapter(Context context, ArrayList<ThreadData> data) {
        this.mContext = context;
        this.mData = data;
    }

    public void setIsProcessNext(boolean b) {
        this.mIsProcessNext = b;
    }

    public boolean getIsProcessNext() {
        return this.mIsProcessNext;
    }

    public void setIsProcessPre(boolean b) {
        this.mIsProcessPre = b;
    }

    public boolean getIsProcessPre() {
        return this.mIsProcessPre;
    }

    public void setHeaderType(int type) {
        this.mHeaderType = type;
    }

    public int getHeaderType() {
        return this.mHeaderType;
    }

    public void setHaveHeader(boolean b) {
        this.mHaveHeader = b;
    }

    public boolean getHaveHeader() {
        return this.mHaveHeader;
    }

    public void setHaveFooter(boolean b) {
        this.mHaveFooter = b;
    }

    public boolean getHaveFooter() {
        return this.mHaveFooter;
    }

    public void setData(ArrayList<ThreadData> data) {
        this.mData = data;
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

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.mData != null) {
            int count = this.mData.size();
            if (this.mHaveHeader) {
                count++;
            }
            if (this.mHaveFooter) {
                count++;
            }
            return count;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int position) {
        int index = (int) getItemId(position);
        if (index < 0 || index >= this.mData.size()) {
            return null;
        }
        Object item = this.mData.get(index);
        return item;
    }

    @Override // android.widget.Adapter
    public long getItemId(int position) {
        int index = position;
        if (this.mHaveHeader) {
            index--;
        }
        if (this.mHaveFooter && position == getCount() - 1) {
            index = -2;
        }
        return index;
    }

    @Override // android.widget.Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        try {
            if (convertView == null) {
                LayoutInflater mInflater = LayoutInflater.from(this.mContext);
                convertView = mInflater.inflate(R.layout.frs_item, (ViewGroup) null);
                ViewHolder holder2 = new ViewHolder(this, null);
                try {
                    holder2.mContent = (RelativeLayout) convertView.findViewById(R.id.frs_list_item);
                    holder2.mReplyNum = (TextView) convertView.findViewById(R.id.frs_lv_reply_num);
                    holder2.mReplyTime = (TextView) convertView.findViewById(R.id.frs_lv_reply_time);
                    holder2.mTitle = (TextView) convertView.findViewById(R.id.frs_lv_title);
                    holder2.mAuthor = (TextView) convertView.findViewById(R.id.frs_lv_author);
                    holder2.mControl = (RelativeLayout) convertView.findViewById(R.id.frs_list_control);
                    holder2.mCtlText = (TextView) convertView.findViewById(R.id.frs_list_control_tv);
                    holder2.mCtlProg = (ProgressBar) convertView.findViewById(R.id.frs_list_control_progress);
                    convertView.setTag(holder2);
                    this.mProgressbars.add(holder2.mCtlProg);
                    holder = holder2;
                } catch (Exception e) {
                    ex = e;
                    TiebaLog.e(getClass().getName(), "", "FrsAdapter.getView error = " + ex.getMessage());
                    return convertView;
                }
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            long data_index = getItemId(position);
            if (data_index == -1) {
                holder.mContent.setVisibility(8);
                holder.mControl.setVisibility(0);
                if (this.mHeaderType == 1) {
                    if (this.mIsProcessPre) {
                        holder.mCtlText.setText(R.string.loading);
                        holder.mCtlProg.setVisibility(0);
                    } else {
                        holder.mCtlText.setText(R.string.like);
                        holder.mCtlProg.setVisibility(8);
                    }
                } else if (this.mIsProcessPre) {
                    holder.mCtlText.setText(R.string.loading);
                    holder.mCtlProg.setVisibility(0);
                } else {
                    holder.mCtlText.setText(R.string.frs_pre);
                    holder.mCtlProg.setVisibility(8);
                }
            } else if (data_index == -2) {
                holder.mContent.setVisibility(8);
                holder.mControl.setVisibility(0);
                holder.mCtlProg.setVisibility(8);
                if (this.mIsProcessNext) {
                    holder.mCtlText.setText(R.string.loading);
                    holder.mCtlProg.setVisibility(0);
                } else {
                    holder.mCtlText.setText(R.string.frs_next);
                    holder.mCtlProg.setVisibility(8);
                }
            } else {
                holder.mContent.setVisibility(0);
                holder.mControl.setVisibility(8);
                holder.mCtlProg.setVisibility(8);
                ThreadData data = (ThreadData) getItem(position);
                int replyNum = data.getReply_num();
                if (replyNum <= 999) {
                    holder.mReplyNum.setText(String.valueOf(replyNum));
                } else {
                    holder.mReplyNum.setText("999+");
                }
                Date tmpDate = new Date();
                tmpDate.setTime(data.getLast_time_int() * 1000);
                String d = StringHelper.GetTimeString(tmpDate);
                holder.mReplyTime.setText(d);
                holder.mTitle.setText(data.getSpan_str());
                holder.mAuthor.setText(data.getAuthor().getName());
            }
        } catch (Exception e2) {
            ex = e2;
        }
        return convertView;
    }

    /* loaded from: classes.dex */
    private class ViewHolder {
        TextView mAuthor;
        RelativeLayout mContent;
        RelativeLayout mControl;
        ProgressBar mCtlProg;
        TextView mCtlText;
        TextView mReplyNum;
        TextView mReplyTime;
        TextView mTitle;

        private ViewHolder() {
        }

        /* synthetic */ ViewHolder(FrsAdapter frsAdapter, ViewHolder viewHolder) {
            this();
        }
    }
}
