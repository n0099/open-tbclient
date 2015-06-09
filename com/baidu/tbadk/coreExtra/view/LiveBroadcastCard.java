package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.LiveRoomChatActivityConfig;
import com.baidu.tbadk.core.data.LiveCardData;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.GroupImageView;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
/* loaded from: classes.dex */
public class LiveBroadcastCard extends FrameLayout {
    private static final long TIME_COUNTDOWN_MAX_MINUTE = 300;
    private TextView card_label;
    private boolean hasBarName;
    private boolean hasLabel;
    private boolean hasLivingTip;
    private boolean isListCard;
    private boolean isShowLivingTip;
    private boolean isVip;
    private int left;
    private TextView mBarFrom;
    public TextView mCardAuthor;
    private Button mCardDelete;
    private TextView mCardIntro;
    private ImageView mCardLikeImage;
    private ae mCardListener;
    private ImageView mCardListenerImage;
    private ImageView mCardLivingImage;
    private ViewGroup mCardMiddle;
    private TextView mCardName;
    private ad mCardOnClickDispatch;
    private ViewGroup mCardRight;
    private ViewGroup mCardStateLayout;
    private int mCardStatus;
    private ViewGroup mCardTextsCenter;
    private TextView mCardTime;
    private ImageView mCardTopTipImage;
    private ImageView mCardVipImage;
    private Context mContext;
    private ah mDeleteListener;
    private int mFromType;
    private int mGroupId;
    private boolean mHasStatus;
    private GroupImageView mHeadImageView;
    private boolean mIntroSingLine;
    private boolean mIsHideSHow;
    private boolean mIsTopTipShow;
    private TextView mLikerCount;
    private TextView mListenerCount;
    private ViewGroup mRootView;
    private long mStartTime;
    private TextView mStateClose;
    private TextView mStateLiving;
    private TextView mStateWillStart;
    private ViewGroup mStateWillStartLayout;
    private String mStatisticsKey;
    private CustomMessageListener mTimeUpdateListener;
    public static int MAX_NAME_LENGTH = 16;
    public static int MAX_LABEL_LENGTH = 3;

    public void setCardClickListener(ae aeVar) {
        this.mCardListener = aeVar;
    }

    public void setCardOnClickDispatch(ad adVar) {
        this.mCardOnClickDispatch = adVar;
    }

    public boolean hasCardOnClickDispatch() {
        return this.mCardOnClickDispatch != null;
    }

    public void setDeleteButtonClickListener(ah ahVar) {
        this.mDeleteListener = ahVar;
    }

    public String getStatisticsKey() {
        return this.mStatisticsKey;
    }

    public void setStatisticsKey(String str) {
        this.mStatisticsKey = str;
    }

    public void setIsTopTipShow(boolean z) {
        this.mIsTopTipShow = z;
    }

    public void setIsHideSHow(boolean z) {
        this.mIsHideSHow = z;
    }

    public void setShowLivingTip(boolean z) {
        this.isShowLivingTip = z;
    }

    public LiveBroadcastCard(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCardStatus = 0;
        this.hasBarName = false;
        this.left = com.baidu.adp.lib.util.n.d(getContext(), com.baidu.tieba.o.ds16);
        this.isListCard = false;
        this.hasLabel = false;
        this.mTimeUpdateListener = new aa(this, 2012113);
        init(context, attributeSet);
    }

    public LiveBroadcastCard(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCardStatus = 0;
        this.hasBarName = false;
        this.left = com.baidu.adp.lib.util.n.d(getContext(), com.baidu.tieba.o.ds16);
        this.isListCard = false;
        this.hasLabel = false;
        this.mTimeUpdateListener = new aa(this, 2012113);
        init(context, attributeSet);
    }

    public LiveBroadcastCard(Context context) {
        super(context);
        this.mCardStatus = 0;
        this.hasBarName = false;
        this.left = com.baidu.adp.lib.util.n.d(getContext(), com.baidu.tieba.o.ds16);
        this.isListCard = false;
        this.hasLabel = false;
        this.mTimeUpdateListener = new aa(this, 2012113);
        init(context, null);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mContext = context;
        View inflate = com.baidu.adp.lib.g.b.hr().inflate(context, com.baidu.tieba.r.livebroadcastcardview, this);
        this.mRootView = (ViewGroup) inflate.findViewById(com.baidu.tieba.q.card_root);
        this.mHeadImageView = (GroupImageView) inflate.findViewById(com.baidu.tieba.q.card_head);
        this.mHeadImageView.setDrawBorder(true);
        this.mHeadImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.mCardMiddle = (ViewGroup) inflate.findViewById(com.baidu.tieba.q.card_middle);
        this.mCardName = (TextView) inflate.findViewById(com.baidu.tieba.q.card_name);
        this.mCardTextsCenter = (ViewGroup) inflate.findViewById(com.baidu.tieba.q.card_texts_center);
        this.mBarFrom = (TextView) inflate.findViewById(com.baidu.tieba.q.card_bar_from);
        this.mListenerCount = (TextView) inflate.findViewById(com.baidu.tieba.q.card_listener_count);
        this.mLikerCount = (TextView) inflate.findViewById(com.baidu.tieba.q.card_liker_count);
        this.mCardAuthor = (TextView) inflate.findViewById(com.baidu.tieba.q.card_author);
        this.mCardIntro = (TextView) inflate.findViewById(com.baidu.tieba.q.card_intro);
        this.mCardRight = (ViewGroup) inflate.findViewById(com.baidu.tieba.q.card_right);
        this.mCardStateLayout = (ViewGroup) inflate.findViewById(com.baidu.tieba.q.card_state);
        this.mStateLiving = (TextView) inflate.findViewById(com.baidu.tieba.q.card_state_living);
        this.mCardTime = (TextView) inflate.findViewById(com.baidu.tieba.q.card_time);
        this.mStateWillStartLayout = (ViewGroup) inflate.findViewById(com.baidu.tieba.q.card_state_willstart_layout);
        this.mStateWillStart = (TextView) inflate.findViewById(com.baidu.tieba.q.card_state_willstart_text);
        this.mStateClose = (TextView) inflate.findViewById(com.baidu.tieba.q.card_state_close);
        this.mCardDelete = (Button) inflate.findViewById(com.baidu.tieba.q.card_delete);
        this.mCardTopTipImage = (ImageView) inflate.findViewById(com.baidu.tieba.q.card_top_image);
        this.mCardListenerImage = (ImageView) inflate.findViewById(com.baidu.tieba.q.card_listener_iamge);
        this.mCardLikeImage = (ImageView) inflate.findViewById(com.baidu.tieba.q.card_liker_image);
        this.mCardVipImage = (ImageView) inflate.findViewById(com.baidu.tieba.q.live_card_vip_icon);
        this.mCardLivingImage = (ImageView) inflate.findViewById(com.baidu.tieba.q.live_card_living_icon);
        this.card_label = (TextView) inflate.findViewById(com.baidu.tieba.q.card_label);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.baidu.tieba.v.LiveBroadcastCard);
            this.mHasStatus = obtainStyledAttributes.getBoolean(0, false);
            this.mIntroSingLine = obtainStyledAttributes.getBoolean(1, true);
            obtainStyledAttributes.recycle();
        }
        if (this.mIntroSingLine) {
            this.mCardMiddle.measure(0, 0);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mCardRight.getLayoutParams();
            layoutParams.height = this.mCardMiddle.getMeasuredHeight();
            this.mCardRight.setLayoutParams(layoutParams);
            this.mCardIntro.setSingleLine();
        }
        setOnClickListener(new ab(this));
        this.mCardDelete.setOnClickListener(new ac(this));
    }

    public void setData(LiveCardData liveCardData) {
        if (liveCardData != null) {
            af.xV().b(this);
            unRegisterTimeUpdateListener();
            this.hasLivingTip = false;
            this.mGroupId = liveCardData.getGroupId();
            this.mFromType = liveCardData.getFromType();
            if (!StringUtils.isNull(liveCardData.getLabelName())) {
                this.hasLabel = true;
                this.card_label.setVisibility(0);
                String labelName = liveCardData.getLabelName();
                if (labelName.length() > MAX_LABEL_LENGTH) {
                    labelName = labelName.substring(0, MAX_LABEL_LENGTH);
                }
                this.card_label.setText(labelName);
            } else {
                this.hasLabel = false;
                this.card_label.setVisibility(8);
            }
            if (!StringUtils.isNull(liveCardData.getName())) {
                String name = liveCardData.getName();
                int fj = com.baidu.tbadk.util.l.fj(name);
                if (this.hasLabel && fj > MAX_NAME_LENGTH) {
                    name = String.valueOf(com.baidu.tbadk.util.l.f(name, 0, MAX_NAME_LENGTH)) + "...";
                }
                this.mCardName.setText(name);
            }
            this.mListenerCount.setText(getFormatNum(liveCardData.getListeners()));
            this.mLikerCount.setText(getFormatNum(liveCardData.getLikers()));
            this.mCardAuthor.setText(liveCardData.getPublisherName());
            this.hasBarName = !StringUtils.isNull(liveCardData.getForumName());
            String str = "";
            if (this.hasBarName) {
                str = UtilHelper.getFixedText(String.valueOf(liveCardData.getForumName()) + this.mContext.getString(com.baidu.tieba.t.bar), 7);
            }
            this.mBarFrom.setText(str);
            this.mCardDelete.setTag(liveCardData);
            this.mHeadImageView.setTag(null);
            this.isVip = liveCardData.getIsVip() == 1;
            if (this.isVip) {
                this.mCardVipImage.setVisibility(0);
                com.baidu.tbadk.core.util.ay.c(this.mCardVipImage, com.baidu.tieba.p.lable_live_v);
            } else {
                this.mCardVipImage.setVisibility(8);
            }
            this.mCardLivingImage.setVisibility(8);
            if (liveCardData.getFromType() == 0) {
                this.mCardTextsCenter.setVisibility(0);
                this.mCardIntro.setSingleLine(true);
                this.mCardIntro.setText(liveCardData.getIntro());
            }
            if (!TextUtils.isEmpty(liveCardData.getPortrait())) {
                this.mHeadImageView.c(liveCardData.getPortrait(), 10, false);
            } else if (!TextUtils.isEmpty(liveCardData.getPublisherPortrait())) {
                this.mHeadImageView.c(liveCardData.getPublisherPortrait(), 12, false);
            } else {
                this.mHeadImageView.c(null, 10, false);
                this.mHeadImageView.c(null, 12, false);
            }
            int status = liveCardData.getStatus();
            if (!this.mHasStatus || status == 1) {
                this.mCardRight.setVisibility(8);
                if (this.isListCard) {
                    if (status == 4 || status == 3 || status == 5) {
                        if (!this.hasBarName) {
                            resetLayoutPadding(this.mCardListenerImage);
                            resetLayoutPadding(this.mCardLikeImage, this.left, 0, 0, 0);
                        } else {
                            resetLayoutPadding(this.mCardListenerImage, this.left, 0, 0, 0);
                            resetLayoutPadding(this.mCardLikeImage, this.left, 0, 0, 0);
                        }
                        this.mListenerCount.setVisibility(0);
                        this.mCardListenerImage.setVisibility(0);
                        this.mCardAuthor.setVisibility(8);
                    } else {
                        if (!this.hasBarName) {
                            resetLayoutPadding(this.mCardLikeImage);
                        } else {
                            resetLayoutPadding(this.mCardLikeImage, this.left, 0, 0, 0);
                        }
                        this.mCardListenerImage.setVisibility(8);
                        this.mListenerCount.setVisibility(8);
                        this.mCardAuthor.setVisibility(0);
                    }
                } else {
                    this.mBarFrom.setVisibility(8);
                    this.hasBarName = false;
                }
            } else {
                this.mCardRight.setVisibility(0);
                if (!this.mIsHideSHow) {
                    switch (status) {
                        case 2:
                            updateStatusWillStart(liveCardData.getStartTime());
                            break;
                        case 3:
                        case 4:
                        case 5:
                            updateStatusLiving();
                            break;
                        case 6:
                            updateStatusClose();
                            break;
                        default:
                            updateStatusClose();
                            break;
                    }
                } else {
                    updateStatusHide();
                }
            }
            ImageView imageView = this.mCardTopTipImage;
            if (this.mIsTopTipShow) {
            }
            imageView.setVisibility(8);
            if (this.mIsHideSHow) {
                com.baidu.tbadk.core.util.ay.b(this.mCardName, com.baidu.tieba.n.cp_cont_e, 1);
                com.baidu.tbadk.core.util.ay.b(this.mBarFrom, com.baidu.tieba.n.cp_cont_e, 1);
                com.baidu.tbadk.core.util.ay.b(this.mListenerCount, com.baidu.tieba.n.cp_cont_e, 1);
                com.baidu.tbadk.core.util.ay.b(this.mLikerCount, com.baidu.tieba.n.cp_cont_e, 1);
                com.baidu.tbadk.core.util.ay.b(this.mCardAuthor, com.baidu.tieba.n.cp_cont_e, 1);
                com.baidu.tbadk.core.util.ay.b(this.mCardIntro, com.baidu.tieba.n.cp_cont_e, 1);
                com.baidu.tbadk.core.util.ay.c(this.mCardListenerImage, com.baidu.tieba.p.icon_live_list_pop_d);
                com.baidu.tbadk.core.util.ay.c(this.mCardLikeImage, com.baidu.tieba.p.icon_live_list_like_d);
                this.mHeadImageView.setForegroundColor(com.baidu.tbadk.core.util.ay.getColor(com.baidu.tieba.n.live_broadcast_card_head_mask));
            } else {
                com.baidu.tbadk.core.util.ay.b(this.mCardName, com.baidu.tieba.n.cp_cont_b, 1);
                com.baidu.tbadk.core.util.ay.b(this.mBarFrom, com.baidu.tieba.n.cp_cont_c, 1);
                com.baidu.tbadk.core.util.ay.b(this.mListenerCount, com.baidu.tieba.n.cp_cont_c, 1);
                com.baidu.tbadk.core.util.ay.b(this.mLikerCount, com.baidu.tieba.n.cp_cont_c, 1);
                com.baidu.tbadk.core.util.ay.b(this.mCardAuthor, com.baidu.tieba.n.cp_cont_c, 1);
                com.baidu.tbadk.core.util.ay.b(this.mCardIntro, com.baidu.tieba.n.cp_cont_d, 1);
                com.baidu.tbadk.core.util.ay.c(this.mCardListenerImage, com.baidu.tieba.p.icon_live_list_pop);
                com.baidu.tbadk.core.util.ay.c(this.mCardLikeImage, com.baidu.tieba.p.icon_live_list_like);
                this.mHeadImageView.setForegroundColor(0);
            }
            com.baidu.tbadk.core.util.ay.b(this.card_label, com.baidu.tieba.n.cp_other_c, 1);
            com.baidu.tbadk.core.util.ay.i((View) this.card_label, com.baidu.tieba.p.bg_essence_list_ba);
        }
    }

    public void setEditState(boolean z) {
        if (this.mHasStatus) {
            if (z) {
                this.mCardStateLayout.setVisibility(8);
                this.mCardDelete.setVisibility(0);
                return;
            }
            this.mCardStateLayout.setVisibility(0);
            this.mCardDelete.setVisibility(8);
        }
    }

    private String getFormatNum(int i) {
        if (i <= 0) {
            return String.valueOf(i);
        }
        if (i > 99999) {
            return "99999+";
        }
        return String.valueOf(i);
    }

    public void setEditState(boolean z, String str) {
        setEditState(z);
        this.mCardDelete.setText(str);
    }

    private void registerTimeUpdateListener() {
        MessageManager.getInstance().registerListener(this.mTimeUpdateListener);
    }

    private void unRegisterTimeUpdateListener() {
        MessageManager.getInstance().unRegisterListener(this.mTimeUpdateListener);
    }

    public void resetLayoutPadding(View view) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        view.setLayoutParams(layoutParams);
    }

    public void resetLayoutPadding(View view, int i, int i2, int i3, int i4) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(i, i2, i3, i4);
        view.setLayoutParams(layoutParams);
    }

    private void updateStatusLiving() {
        if (this.isListCard) {
            if (!this.hasBarName) {
                resetLayoutPadding(this.mCardListenerImage);
                resetLayoutPadding(this.mCardLikeImage, this.left, 0, 0, 0);
            } else {
                resetLayoutPadding(this.mCardListenerImage, this.left, 0, 0, 0);
                resetLayoutPadding(this.mCardLikeImage, this.left, 0, 0, 0);
            }
            this.mListenerCount.setVisibility(0);
            this.mCardListenerImage.setVisibility(0);
            this.mCardAuthor.setVisibility(8);
        } else {
            this.mBarFrom.setVisibility(8);
            resetLayoutPadding(this.mCardListenerImage);
        }
        this.mStateLiving.setVisibility(0);
        this.mStateWillStartLayout.setVisibility(8);
        this.mStateClose.setVisibility(8);
        if (this.isShowLivingTip) {
            if (this.isVip) {
                this.mCardLivingImage.setVisibility(0);
                this.hasLivingTip = true;
            } else {
                this.mCardLivingImage.setVisibility(8);
            }
        } else {
            this.mCardLivingImage.setVisibility(8);
        }
        this.mCardStatus = 3;
        af.xV().b(this);
        unRegisterTimeUpdateListener();
    }

    public boolean isHasLivingTip() {
        return this.hasLivingTip;
    }

    private void updateStatusWillStart(long j) {
        if (this.isListCard) {
            if (!this.hasBarName) {
                resetLayoutPadding(this.mCardLikeImage);
            } else {
                resetLayoutPadding(this.mCardLikeImage, this.left, 0, 0, 0);
            }
            this.mCardListenerImage.setVisibility(8);
            this.mListenerCount.setVisibility(8);
            this.mCardAuthor.setVisibility(0);
        } else {
            this.mBarFrom.setVisibility(8);
            resetLayoutPadding(this.mCardListenerImage);
        }
        this.mStateLiving.setVisibility(8);
        this.mStateWillStartLayout.setVisibility(0);
        this.mStateClose.setVisibility(8);
        this.mStartTime = j;
        this.mCardStatus = 0;
        dealStatusWillStart();
        registerTimeUpdateListener();
        af.xV().a(this);
    }

    private void updateStatusClose() {
        if (this.isListCard) {
            if (!this.hasBarName) {
                resetLayoutPadding(this.mCardLikeImage);
            } else {
                resetLayoutPadding(this.mCardLikeImage, this.left, 0, 0, 0);
            }
            this.mCardListenerImage.setVisibility(8);
            this.mListenerCount.setVisibility(8);
            this.mCardAuthor.setVisibility(0);
        } else {
            this.mBarFrom.setVisibility(8);
            resetLayoutPadding(this.mCardListenerImage);
        }
        this.mStateLiving.setVisibility(8);
        this.mStateWillStartLayout.setVisibility(8);
        this.mStateClose.setVisibility(0);
        this.mStateClose.setText(com.baidu.tieba.t.live_card_close);
        com.baidu.tbadk.core.util.ay.b(this.mStateClose, com.baidu.tieba.n.cp_cont_d, 1);
        this.mStateClose.setTextSize(0, getResources().getDimensionPixelSize(com.baidu.tieba.o.ds28));
        this.mCardStatus = 4;
    }

    private void updateStatusHide() {
        if (this.isListCard) {
            if (!this.hasBarName) {
                resetLayoutPadding(this.mCardLikeImage);
            } else {
                resetLayoutPadding(this.mCardLikeImage, this.left, 0, 0, 0);
            }
            this.mCardListenerImage.setVisibility(8);
            this.mListenerCount.setVisibility(8);
            this.mCardAuthor.setVisibility(0);
        } else {
            this.mBarFrom.setVisibility(8);
            resetLayoutPadding(this.mCardListenerImage);
        }
        this.mStateLiving.setVisibility(8);
        this.mStateWillStartLayout.setVisibility(8);
        this.mStateClose.setVisibility(0);
        this.mStateClose.setText(com.baidu.tieba.t.live_card_hide);
        com.baidu.tbadk.core.util.ay.b(this.mStateClose, com.baidu.tieba.n.cp_cont_d, 1);
        this.mStateClose.setTextSize(0, getResources().getDimensionPixelSize(com.baidu.tieba.o.ds32));
        this.mCardStatus = 5;
    }

    private void updateStatusWillStartCountDown() {
        this.mStateWillStart.setText(com.baidu.tieba.t.live_card_count_down);
        com.baidu.tbadk.core.util.ay.i((View) this.mStateWillStart, com.baidu.tieba.p.bg_live_orange);
        this.mCardStatus = 2;
    }

    private void updateStatusWillStartForeShow() {
        this.mCardTime.setText(getFormatHour(this.mStartTime));
        this.mStateWillStart.setText(com.baidu.tieba.t.live_card_foreshowt);
        com.baidu.tbadk.core.util.ay.i((View) this.mStateWillStart, com.baidu.tieba.p.bg_live_yellow);
        this.mCardStatus = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goToLiveBroadcastAcvitity() {
        if (this.mFromType == 0) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LiveRoomChatActivityConfig(this.mContext, this.mGroupId)));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        af.xV().b(this);
        unRegisterTimeUpdateListener();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dealStatusWillStart() {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (currentTimeMillis >= this.mStartTime) {
            if (this.mCardStatus != 3) {
                updateStatusLiving();
                return;
            }
            return;
        }
        long j = this.mStartTime - currentTimeMillis;
        if (j <= TIME_COUNTDOWN_MAX_MINUTE) {
            if (this.mCardStatus != 2) {
                updateStatusWillStartCountDown();
            }
            this.mCardTime.setText(getFormatMinute(j));
        } else if (this.mCardStatus != 1) {
            updateStatusWillStartForeShow();
        }
    }

    private String getFormatMinute(long j) {
        return new SimpleDateFormat("mm:ss", Locale.CHINA).format(new Date(1000 * j));
    }

    private String getFormatHour(long j) {
        return new SimpleDateFormat("HH:mm", Locale.CHINA).format(new Date(1000 * j));
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        tbPageContext.getLayoutMode().ab(i == 1);
        tbPageContext.getLayoutMode().j(this.mRootView);
    }

    public void setmHasStatus(boolean z) {
        this.mHasStatus = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
        super.dispatchSetPressed(z);
    }

    public boolean isListCard() {
        return this.isListCard;
    }

    public void setListCard(boolean z) {
        this.isListCard = z;
    }
}
