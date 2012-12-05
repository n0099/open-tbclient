package com.baidu.tieba.frs;

import android.content.Context;
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
import com.baidu.tieba.data.Config;
import com.baidu.tieba.data.FrsStarData;
import com.baidu.tieba.data.MediaData;
import com.baidu.tieba.data.ThreadData;
import com.baidu.tieba.util.AsyncImageLoader;
import com.baidu.tieba.util.ReadThreadHistory;
import com.baidu.tieba.util.StringHelper;
import com.baidu.tieba.util.TiebaLog;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.view.CustomTimerView;
import com.baidu.tieba.view.FrsImageView;
import com.baidu.tieba.view.FrsStarImageView;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes.dex */
public class FrsAdapter extends BaseAdapter {
    Context mContext;
    ArrayList<ThreadData> mData;
    private boolean mHaveFooter;
    private boolean mHaveHeader;
    private AsyncImageLoader mImageLoader;
    private boolean mIsProcessNext;
    private boolean mIsProcessPre;
    private int mScreenWidth;
    private AsyncImageLoader mStarImageLoader;
    FrsStarData mStarData = null;
    String mForumName = null;
    ThreadData mStarTitleImg = null;
    private boolean mIsShowStarTitle = false;
    private View.OnClickListener mImageOnClickListener = null;
    private ArrayList<ProgressBar> mProgressbars = new ArrayList<>();
    private boolean isAbstractOn = false;

    private LinearLayout createImageView(final MediaData media, int n) {
        if (media.getVideoUrl() != null && (media.getVideoUrl().length() < 1 || media.getVideoUrl().endsWith("swf"))) {
            return null;
        }
        FrsImageView imageView = new FrsImageView(this.mContext, media.getType());
        LinearLayout mLinearLayout = new LinearLayout(this.mContext);
        if (n == 3) {
            imageView.setIsThree(true);
        }
        LinearLayout.LayoutParams imageViewparams = new LinearLayout.LayoutParams((this.mScreenWidth - UtilHelper.dip2px(this.mContext, (n * 2) + 30)) / n, (this.mScreenWidth - UtilHelper.px2dip(this.mContext, 30.0f)) / 4);
        LinearLayout.LayoutParams layoutViewparams = new LinearLayout.LayoutParams((ViewGroup.MarginLayoutParams) imageViewparams);
        int px_v = UtilHelper.dip2px(this.mContext, 10.0f);
        layoutViewparams.rightMargin = UtilHelper.dip2px(this.mContext, 2.0f);
        layoutViewparams.topMargin = px_v;
        layoutViewparams.bottomMargin = 0;
        imageView.setTag(media.getPicUrl());
        imageView.setClickable(true);
        imageView.setFocusable(false);
        imageView.setLayoutParams(imageViewparams);
        mLinearLayout.setLayoutParams(layoutViewparams);
        mLinearLayout.addView(imageView);
        if (media.getType() == 5) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    UtilHelper.startWebActivity(FrsAdapter.this.mContext, media.getVideoUrl());
                }
            });
            return mLinearLayout;
        } else if (media.getType() == 3) {
            imageView.setOnClickListener(this.mImageOnClickListener);
            return mLinearLayout;
        } else {
            return mLinearLayout;
        }
    }

    public void setImageOnclickListener(View.OnClickListener listener) {
        this.mImageOnClickListener = listener;
    }

    public void setAbstractState(boolean src) {
        this.isAbstractOn = src;
    }

    public FrsAdapter(Context context, ArrayList<ThreadData> data, int imageMaxWidth) {
        this.mContext = context;
        this.mData = data;
        this.mImageLoader = new AsyncImageLoader(this.mContext);
        this.mImageLoader.setSuffix(AsyncImageLoader.SMALL);
        this.mImageLoader.setQuality(true);
        this.mScreenWidth = imageMaxWidth;
        imageMaxWidth = imageMaxWidth > Config.THREAD_IMAGE_MAX_WIDTH ? Config.THREAD_IMAGE_MAX_WIDTH : imageMaxWidth;
        this.mImageLoader.setImagesize(imageMaxWidth, (imageMaxWidth - UtilHelper.dip2px(this.mContext, 6.0f)) / 4);
        this.mStarImageLoader = new AsyncImageLoader(this.mContext);
        this.mStarImageLoader.setImagesize(UtilHelper.getEquipmentWidth(this.mContext), UtilHelper.getEquipmentWidth(this.mContext));
    }

    public AsyncImageLoader getImageLoader() {
        return this.mImageLoader;
    }

    public AsyncImageLoader getStarImageLoader() {
        return this.mStarImageLoader;
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

    public void setHaveStarTitle(boolean b) {
        this.mIsShowStarTitle = b;
    }

    public boolean getHaveStarTitle() {
        return this.mIsShowStarTitle;
    }

    public void setData(ArrayList<ThreadData> data) {
        this.mData = data;
    }

    public void setStarData(FrsStarData data, String forumName) {
        this.mStarData = data;
        this.mForumName = forumName;
        this.mStarTitleImg = new ThreadData();
        MediaData topPicData = new MediaData();
        topPicData.setType(3);
        topPicData.setPic(data.getTopPic());
        this.mStarTitleImg.getMedias().add(topPicData);
        MediaData photoData = new MediaData();
        photoData.setType(3);
        photoData.setPic(data.getPhoto());
        this.mStarTitleImg.getMedias().add(photoData);
    }

    public ThreadData getStarTitleImg() {
        return this.mStarTitleImg;
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
            if (this.mIsShowStarTitle) {
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
        if (this.mIsShowStarTitle) {
            index--;
        }
        if (this.mHaveHeader) {
            index--;
        }
        if (this.mHaveFooter && position == getCount() - 1) {
            index = -2;
        }
        if (this.mIsShowStarTitle && position == 0) {
            index = -3;
        }
        return index;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int position) {
        long id = getItemId(position);
        return id == -3 ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        View temp;
        ViewHolder holder = null;
        StarViewHolder starHolder = null;
        try {
            int viewType = getItemViewType(position);
            if (convertView == null) {
                if (viewType == 0) {
                    LayoutInflater mInflater = LayoutInflater.from(this.mContext);
                    convertView = mInflater.inflate(R.layout.frs_item, (ViewGroup) null);
                    ViewHolder holder2 = new ViewHolder(this, null);
                    try {
                        holder2.mContent = (LinearLayout) convertView.findViewById(R.id.frs_list_item);
                        holder2.mReplyNum = (TextView) convertView.findViewById(R.id.frs_lv_reply_num);
                        holder2.mReplyTime = (TextView) convertView.findViewById(R.id.frs_lv_reply_time);
                        holder2.mTitle = (TextView) convertView.findViewById(R.id.frs_lv_title);
                        holder2.mAuthor = (TextView) convertView.findViewById(R.id.frs_lv_author);
                        holder2.abstractLayout = (LinearLayout) convertView.findViewById(R.id.frs_lv_abstract);
                        holder2.abstractTextView = (TextView) convertView.findViewById(R.id.abstract_text);
                        holder2.mSeg = (LinearLayout) convertView.findViewById(R.id.abstract_img_layout);
                        holder2.mReplayIcon = (ImageView) convertView.findViewById(R.id.frs_lv_autor_icon);
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
                    LayoutInflater inflater = LayoutInflater.from(this.mContext);
                    convertView = inflater.inflate(R.layout.frs_star_title, (ViewGroup) null);
                    StarViewHolder starHolder2 = new StarViewHolder(this, null);
                    try {
                        starHolder2.mStarTopPic = (FrsStarImageView) convertView.findViewById(R.id.frs_star_top_pic);
                        starHolder2.mStarPhoto = (FrsStarImageView) convertView.findViewById(R.id.frs_star_photo);
                        starHolder2.mStarTopPic.setImageType(0);
                        starHolder2.mStarPhoto.setImageType(1);
                        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) starHolder2.mStarTopPic.getLayoutParams();
                        params.width = UtilHelper.getEquipmentWidth(this.mContext);
                        if (this.mStarData.getTopPicWidth() == 0) {
                            params.height = 1;
                        } else {
                            params.height = (params.width * this.mStarData.getTopPicHeight()) / this.mStarData.getTopPicWidth();
                        }
                        starHolder2.mStarTopPic.setLayoutParams(params);
                        RelativeLayout.LayoutParams params2 = (RelativeLayout.LayoutParams) starHolder2.mStarPhoto.getLayoutParams();
                        params2.width = UtilHelper.getEquipmentWidth(this.mContext) / 4;
                        if (this.mStarData.getPhotoWidth() == 0) {
                            params2.height = params2.width;
                        } else {
                            params2.height = (params2.width * this.mStarData.getPhotoHeight()) / this.mStarData.getPhotoWidth();
                        }
                        starHolder2.mStarPhoto.setLayoutParams(params2);
                        starHolder2.mStarTopPic.setTag(this.mStarData.getTopPic());
                        starHolder2.mStarPhoto.setTag(this.mStarData.getPhoto());
                        starHolder2.mTxtAddFanTip = (TextView) convertView.findViewById(R.id.add_fan_tip);
                        starHolder2.mStarTextLayout = (RelativeLayout) convertView.findViewById(R.id.frs_star_text_layout);
                        RelativeLayout.LayoutParams params3 = (RelativeLayout.LayoutParams) starHolder2.mStarTextLayout.getLayoutParams();
                        params3.leftMargin = params2.leftMargin + params2.width + UtilHelper.dip2px(this.mContext, 13.0f);
                        starHolder2.mStarTextLayout.setLayoutParams(params3);
                        starHolder2.mStarText1 = (TextView) convertView.findViewById(R.id.frs_star_text1);
                        starHolder2.mBtnAddFan = (Button) convertView.findViewById(R.id.add_fan);
                        starHolder2.mBtnAddFan.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsAdapter.2
                            @Override // android.view.View.OnClickListener
                            public void onClick(View arg0) {
                                ((FrsActivity) FrsAdapter.this.mContext).startAddFanAsyncTask();
                            }
                        });
                        starHolder2.mTxtFanNum = (TextView) convertView.findViewById(R.id.fan_num);
                        starHolder2.mTimer = (CustomTimerView) convertView.findViewById(R.id.open_timer);
                        starHolder2.mTimer.setTitle(R.string.star_timer_title);
                        starHolder2.mTimer.setTitleSize(15);
                        starHolder2.mTimer.setTitleColor(-8289919);
                        starHolder2.mTimer.setTextSize(14);
                        starHolder2.mTimer.setTextColor(-8289919);
                        starHolder2.mTimer.setNumSize(14);
                        starHolder2.mTimer.setNumColor(-16749848);
                        starHolder2.mTimer.setTextMargin(12);
                        starHolder2.mTimer.setNumMargin(6);
                        convertView.setTag(starHolder2);
                        starHolder = starHolder2;
                    } catch (Exception e2) {
                        ex = e2;
                        TiebaLog.e(getClass().getName(), "", "FrsAdapter.getView error = " + ex.getMessage());
                        return convertView;
                    }
                }
            } else if (viewType == 0) {
                holder = (ViewHolder) convertView.getTag();
            } else {
                starHolder = (StarViewHolder) convertView.getTag();
            }
            long data_index = getItemId(position);
            if (data_index == -1) {
                holder.mContent.setVisibility(8);
                holder.mControl.setVisibility(0);
                if (this.mIsProcessPre) {
                    holder.mCtlText.setText(R.string.loading);
                    holder.mCtlProg.setVisibility(0);
                } else {
                    holder.mCtlText.setText(R.string.frs_pre);
                    holder.mCtlProg.setVisibility(8);
                }
            } else if (data_index == -2) {
                holder.mContent.setVisibility(8);
                holder.mControl.setVisibility(0);
                if (this.mIsProcessNext) {
                    holder.mCtlText.setText(R.string.loading);
                    holder.mCtlProg.setVisibility(0);
                } else {
                    holder.mCtlText.setText(R.string.frs_next);
                    holder.mCtlProg.setVisibility(8);
                }
            } else if (data_index == -3) {
                if (this.mStarData.isOpen() == 0) {
                    starHolder.mTxtFanNum.setVisibility(8);
                    starHolder.mBtnAddFan.setVisibility(8);
                    starHolder.mTimer.setVisibility(0);
                    starHolder.mStarTextLayout.setVisibility(8);
                    starHolder.mTxtAddFanTip.setVisibility(0);
                } else {
                    starHolder.mStarTextLayout.setVisibility(0);
                    starHolder.mTxtAddFanTip.setVisibility(8);
                    if (this.mStarData.isFan() == 0) {
                        starHolder.mTxtFanNum.setVisibility(8);
                        starHolder.mTimer.setVisibility(8);
                        starHolder.mBtnAddFan.setVisibility(0);
                        starHolder.mStarText1.setText(R.string.click_get);
                    } else {
                        starHolder.mBtnAddFan.setVisibility(8);
                        starHolder.mTimer.setVisibility(8);
                        starHolder.mTxtFanNum.setVisibility(0);
                        starHolder.mTxtFanNum.setText(String.valueOf(this.mStarData.getFanNum()));
                        starHolder.mStarText1.setText("我的" + this.mForumName + "吧");
                    }
                }
            } else {
                holder.mContent.setVisibility(0);
                holder.mControl.setVisibility(8);
                holder.mCtlProg.setVisibility(8);
                ThreadData data = (ThreadData) getItem(position);
                int replyNum = data.getReply_num();
                if (replyNum <= 999) {
                    if (replyNum > 0) {
                        holder.mReplayIcon.setVisibility(0);
                        holder.mReplyNum.setText(String.valueOf(replyNum));
                    } else {
                        holder.mReplayIcon.setVisibility(8);
                        holder.mReplyNum.setText((CharSequence) null);
                    }
                } else {
                    holder.mReplyNum.setText("999+");
                }
                Date tmpDate = new Date();
                tmpDate.setTime(data.getLast_time_int() * 1000);
                String d = StringHelper.GetTimeString(tmpDate);
                holder.mReplyTime.setText(d);
                holder.mTitle.setText(data.getSpan_str());
                holder.mTitle.setTextColor(-16777216);
                ReadThreadHistory history = TiebaApplication.app.getReadThreadHistory();
                if (history != null && history.getThread(data.getId())) {
                    holder.mTitle.setTextColor(this.mContext.getResources().getColor(R.color.read_thread_color));
                }
                holder.mAuthor.setText(data.getAuthor().getName());
                if (this.isAbstractOn && data.getIs_top() != 1) {
                    holder.abstractLayout.setVisibility(0);
                    holder.mSeg.setVisibility(0);
                    holder.abstractTextView.setVisibility(0);
                    ArrayList<MediaData> medias = data.getMedias();
                    String abstractText = "";
                    if (data.getAbstract() != null) {
                        abstractText = String.valueOf("") + data.getAbstract();
                    }
                    if (medias != null) {
                        for (int i = 0; i < medias.size(); i++) {
                            if (medias.get(i).getVideoUrl() != null && medias.get(i).getVideoUrl().endsWith("swf")) {
                                abstractText = String.valueOf(abstractText) + medias.get(i).getVideoUrl();
                            }
                        }
                        if (abstractText != null && abstractText.length() > 1) {
                            holder.abstractTextView.setText(abstractText);
                        } else {
                            holder.abstractTextView.setVisibility(8);
                        }
                        if (medias.size() > 0) {
                            holder.mSeg.removeAllViews();
                            int picNum = 0;
                            for (int i2 = 0; i2 < medias.size(); i2++) {
                                if (medias.get(i2) != null && (medias.get(i2).getType() == 3 || medias.get(i2).getType() == 5)) {
                                    picNum++;
                                }
                            }
                            if (picNum > 3) {
                                picNum = 3;
                            }
                            int j = 0;
                            for (int i3 = 0; i3 < medias.size() && j < picNum; i3++) {
                                if ((medias.get(i3).getType() == 3 || medias.get(i3).getType() == 5) && (temp = createImageView(medias.get(i3), picNum)) != null) {
                                    holder.mSeg.addView(temp);
                                    j++;
                                }
                            }
                        } else {
                            holder.mSeg.setVisibility(8);
                        }
                    }
                } else {
                    holder.abstractLayout.setVisibility(8);
                }
            }
        } catch (Exception e3) {
            ex = e3;
        }
        return convertView;
    }

    /* loaded from: classes.dex */
    private class ViewHolder {
        LinearLayout abstractLayout;
        TextView abstractTextView;
        TextView mAuthor;
        LinearLayout mContent;
        RelativeLayout mControl;
        ProgressBar mCtlProg;
        TextView mCtlText;
        ImageView mReplayIcon;
        TextView mReplyNum;
        TextView mReplyTime;
        LinearLayout mSeg;
        TextView mTitle;

        private ViewHolder() {
        }

        /* synthetic */ ViewHolder(FrsAdapter frsAdapter, ViewHolder viewHolder) {
            this();
        }
    }

    /* loaded from: classes.dex */
    private class StarViewHolder {
        Button mBtnAddFan;
        FrsStarImageView mStarPhoto;
        TextView mStarText1;
        RelativeLayout mStarTextLayout;
        FrsStarImageView mStarTopPic;
        CustomTimerView mTimer;
        TextView mTxtAddFanTip;
        TextView mTxtFanNum;

        private StarViewHolder() {
        }

        /* synthetic */ StarViewHolder(FrsAdapter frsAdapter, StarViewHolder starViewHolder) {
            this();
        }
    }
}
