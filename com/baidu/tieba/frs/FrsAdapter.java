package com.baidu.tieba.frs;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
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
    private String mSignText;
    private ArrayList<ProgressBar> mProgressbars = new ArrayList<>();
    private boolean mOnlyLike = false;
    private boolean mOnlySign = false;
    private boolean mLike = false;
    private boolean mSign = false;

    public void setLikeSign(boolean liked, boolean signed) {
        this.mOnlyLike = false;
        this.mOnlySign = false;
        this.mLike = liked;
        this.mSign = signed;
    }

    public void setLike(boolean liked) {
        this.mLike = liked;
    }

    public void setSign(boolean signed) {
        this.mSign = signed;
    }

    public void setOnlyLike(boolean liked) {
        this.mOnlyLike = true;
        this.mLike = liked;
    }

    public void setOnlySigned(boolean signed, String signText) {
        this.mOnlySign = true;
        this.mSign = signed;
        this.mSignText = signText;
    }

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
        String likeTextString;
        SpannableString text;
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
                    holder2.mSignLike = (LinearLayout) convertView.findViewById(R.id.signlike_layout);
                    holder2.mSignOnly = (LinearLayout) convertView.findViewById(R.id.signonly_layout);
                    holder2.mSignOnly.setEnabled(false);
                    holder2.mSignLike.setEnabled(false);
                    holder2.mControl = (RelativeLayout) convertView.findViewById(R.id.frs_list_control);
                    holder2.mCtlText = (TextView) convertView.findViewById(R.id.frs_list_control_tv);
                    holder2.mCtlProg = (ProgressBar) convertView.findViewById(R.id.frs_list_control_progress);
                    holder2.likeLayout = (LinearLayout) convertView.findViewById(R.id.frs_list_like);
                    holder2.signLayout = (LinearLayout) convertView.findViewById(R.id.frs_list_sign);
                    holder2.likeText = (TextView) convertView.findViewById(R.id.like_textview);
                    holder2.signText = (TextView) convertView.findViewById(R.id.sign_textview);
                    holder2.signIcon = (ImageView) convertView.findViewById(R.id.sign_icon);
                    holder2.signOnlyCon = (LinearLayout) convertView.findViewById(R.id.signonly_text);
                    holder2.signOnlyLayout = (LinearLayout) convertView.findViewById(R.id.signonly_sign);
                    holder2.signOnlyConText = (TextView) convertView.findViewById(R.id.signonly_textview);
                    holder2.signOnlyIcoText = (TextView) convertView.findViewById(R.id.sign0_textview);
                    holder2.signOnlyIcon = (ImageView) convertView.findViewById(R.id.sign0_icon);
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
                holder.mSignLike.setVisibility(8);
                holder.mSignOnly.setVisibility(8);
                holder.likeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsAdapter.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View arg0) {
                        ((FrsActivity) FrsAdapter.this.mContext).execLike();
                    }
                });
                holder.signLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsAdapter.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View arg0) {
                        ((FrsActivity) FrsAdapter.this.mContext).execSign();
                    }
                });
                holder.signOnlyLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsAdapter.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View arg0) {
                        ((FrsActivity) FrsAdapter.this.mContext).execSign();
                    }
                });
                holder.signOnlyCon.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsAdapter.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View arg0) {
                    }
                });
                if (this.mHeaderType == 1) {
                    if (this.mIsProcessPre) {
                        holder.mCtlText.setText(R.string.loading);
                        holder.mCtlProg.setVisibility(0);
                    } else {
                        holder.mControl.setEnabled(false);
                        Resources rs = this.mContext.getResources();
                        holder.mControl.setVisibility(8);
                        if (this.mOnlySign) {
                            holder.mSignOnly.setVisibility(0);
                            if (!this.mSign) {
                                holder.signOnlyIcoText.setText(this.mContext.getResources().getString(R.string.sign));
                                holder.signOnlyLayout.setEnabled(true);
                                holder.signOnlyIcon.setVisibility(0);
                                holder.signOnlyIcoText.setTextColor(rs.getColor(R.color.frs_sign_enable));
                                int signRankInt = Integer.valueOf(this.mSignText).intValue();
                                if (signRankInt != 0) {
                                    String signRank = rs.getString(R.string.sign_forum);
                                    text = new SpannableString(signRank.replace("?", this.mSignText));
                                    text.setSpan(new ForegroundColorSpan(Color.rgb(232, 0, 0)), 9, this.mSignText.length() + 9, 33);
                                } else {
                                    String noRank = rs.getString(R.string.nosign_forum);
                                    text = new SpannableString(noRank);
                                }
                            } else {
                                holder.signOnlyIcoText.setText(this.mContext.getResources().getString(R.string.signed));
                                holder.signOnlyLayout.setEnabled(false);
                                holder.signOnlyIcon.setVisibility(8);
                                holder.signOnlyIcoText.setTextColor(rs.getColor(R.color.frs_likesign_disable));
                                String signRank2 = rs.getString(R.string.sign_user);
                                text = new SpannableString(signRank2.replace("?", this.mSignText));
                                text.setSpan(new ForegroundColorSpan(Color.rgb(232, 0, 0)), 10, this.mSignText.length() + 10, 33);
                            }
                            holder.signOnlyConText.setText(text);
                        } else {
                            holder.mSignLike.setVisibility(0);
                            if (!this.mLike) {
                                likeTextString = this.mContext.getResources().getString(R.string.ilike);
                                holder.likeLayout.setEnabled(true);
                                holder.likeText.setTextColor(rs.getColor(R.color.frs_like_enable));
                            } else {
                                likeTextString = this.mContext.getResources().getString(R.string.iliked);
                                holder.likeLayout.setEnabled(false);
                                holder.likeText.setTextColor(rs.getColor(R.color.frs_likesign_disable));
                            }
                            if (!this.mSign) {
                                holder.signText.setText(this.mContext.getResources().getString(R.string.sign));
                                holder.signLayout.setEnabled(true);
                                holder.signIcon.setVisibility(0);
                                holder.signText.setTextColor(rs.getColor(R.color.frs_sign_enable));
                            } else {
                                holder.signText.setText(this.mContext.getResources().getString(R.string.signed));
                                holder.signLayout.setEnabled(false);
                                holder.signIcon.setVisibility(8);
                                holder.signText.setTextColor(rs.getColor(R.color.frs_likesign_disable));
                            }
                            holder.likeText.setText(likeTextString);
                            if (this.mOnlyLike) {
                                holder.signLayout.setVisibility(8);
                            }
                        }
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
                holder.mSignLike.setVisibility(8);
                holder.mCtlProg.setVisibility(8);
                holder.mSignLike.setVisibility(8);
                holder.mSignOnly.setVisibility(8);
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
                holder.mSignLike.setVisibility(8);
                holder.mSignOnly.setVisibility(8);
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
        LinearLayout likeLayout;
        TextView likeText;
        TextView mAuthor;
        RelativeLayout mContent;
        RelativeLayout mControl;
        ProgressBar mCtlProg;
        TextView mCtlText;
        TextView mReplyNum;
        TextView mReplyTime;
        LinearLayout mSignLike;
        LinearLayout mSignOnly;
        TextView mTitle;
        ImageView signIcon;
        LinearLayout signLayout;
        LinearLayout signOnlyCon;
        TextView signOnlyConText;
        TextView signOnlyIcoText;
        ImageView signOnlyIcon;
        LinearLayout signOnlyLayout;
        TextView signText;

        private ViewHolder() {
        }

        /* synthetic */ ViewHolder(FrsAdapter frsAdapter, ViewHolder viewHolder) {
            this();
        }
    }
}
