package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.design.widget.AppBarLayout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.e.c;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SquareSearchActivityConfig;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.data.i;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class NestedScrollHeader extends RelativeLayout {
    CustomMessageListener hAz;
    View.OnClickListener iBZ;
    private PublishButton iIM;
    private TbImageView iIN;
    private ImageView iIO;
    private TextView iIP;
    private a iIQ;
    private Bitmap iIR;
    private CustomMessageListener mSyncFinishListener;

    /* loaded from: classes16.dex */
    public interface a {
        void JD(String str);
    }

    public NestedScrollHeader(@NonNull Context context) {
        this(context, null);
    }

    public NestedScrollHeader(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NestedScrollHeader(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iBZ = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    if (NestedScrollHeader.this.iIN == view) {
                        Object tag = NestedScrollHeader.this.iIN.getTag(R.id.homepage_mission_entrance_url);
                        if (tag instanceof String) {
                            String str = (String) tag;
                            if (!TextUtils.isEmpty(str)) {
                                if (NestedScrollHeader.this.iIQ != null) {
                                    NestedScrollHeader.this.iIQ.JD(str);
                                }
                                NestedScrollHeader.this.cww();
                            }
                        }
                    } else if (NestedScrollHeader.this.iIP != view) {
                        if (NestedScrollHeader.this.iIO != view) {
                            if (NestedScrollHeader.this.iIM == view) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921452, new i(1)));
                                TiebaStatic.log(new aq("c13702").dD("uid", TbadkCoreApplication.getCurrentAccount()));
                                return;
                            }
                            return;
                        }
                        String missionEntranceUrl = TbSingleton.getInstance().getMissionEntranceUrl();
                        if (TextUtils.isEmpty(missionEntranceUrl)) {
                            missionEntranceUrl = "https://haokan.baidu.com/activity/h5/vault?productid=8&tab=act&tag=shitu&pd=1&source=1-101-1&idfrom=1&tbioswk=1";
                        }
                        if (NestedScrollHeader.this.iIQ != null) {
                            NestedScrollHeader.this.iIQ.JD(missionEntranceUrl);
                        }
                    } else {
                        TiebaStatic.log(new aq(CommonStatisticKey.SEARCH_BAR_CLICK).ai("obj_type", 1));
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new SquareSearchActivityConfig(NestedScrollHeader.this.getContext(), "", false)));
                    }
                } catch (Exception e) {
                }
            }
        };
        this.hAz = new CustomMessageListener(2921396) { // from class: com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                NestedScrollHeader.this.setSearchHint(TbSingleton.getInstance().getHotSearch());
            }
        };
        this.mSyncFinishListener = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371 && NestedScrollHeader.this.iIN.getVisibility() == 0) {
                    NestedScrollHeader.this.cwv();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.layout_presenlize_scroll_header, (ViewGroup) this, true);
        this.iIM = (PublishButton) findViewById(R.id.publish_btn);
        this.iIN = (TbImageView) findViewById(R.id.task);
        this.iIO = (ImageView) findViewById(R.id.abtest_task);
        this.iIP = (TextView) findViewById(R.id.search);
        this.iIM.setOnClickListener(this.iBZ);
        this.iIN.setOnClickListener(this.iBZ);
        this.iIO.setOnClickListener(this.iBZ);
        this.iIP.setOnClickListener(this.iBZ);
        MessageManager.getInstance().registerListener(this.hAz);
        MessageManager.getInstance().registerListener(this.mSyncFinishListener);
        this.iIM.setVisibility(8);
        this.iIO.setVisibility(8);
        this.iIN.setVisibility(0);
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            @RequiresApi(api = 16)
            public void onGlobalLayout() {
                if (NestedScrollHeader.this.getLayoutParams() instanceof AppBarLayout.LayoutParams) {
                    AppBarLayout.LayoutParams layoutParams = (AppBarLayout.LayoutParams) NestedScrollHeader.this.getLayoutParams();
                    layoutParams.setScrollFlags(5);
                    NestedScrollHeader.this.setLayoutParams(layoutParams);
                }
                NestedScrollHeader.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        });
        this.iIN.setVisibility(0);
        cwv();
        onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwv() {
        final String missionEntranceUrl = TbSingleton.getInstance().getMissionEntranceUrl();
        String missionEntranceIcon = TbSingleton.getInstance().getMissionEntranceIcon();
        if (TextUtils.isEmpty(missionEntranceUrl) || TextUtils.isEmpty(missionEntranceIcon)) {
            this.iIR = null;
            this.iIN.setTag(R.id.homepage_mission_entrance_url, "https://haokan.baidu.com/activity/h5/vault?productid=8&tab=act&tag=shitu&pd=1&source=1-101-1&idfrom=1&tbioswk=1");
            this.iIN.setImageResource(R.drawable.btn_home_task_n);
            return;
        }
        c.mM().a(missionEntranceIcon, 10, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass2) aVar, str, i);
                if (aVar == null || aVar.getRawBitmap() == null || aVar.getRawBitmap().isRecycled()) {
                    NestedScrollHeader.this.iIR = null;
                    NestedScrollHeader.this.iIN.setImageResource(R.drawable.btn_home_task_n);
                    NestedScrollHeader.this.iIN.setTag(R.id.homepage_mission_entrance_url, "https://haokan.baidu.com/activity/h5/vault?productid=8&tab=act&tag=shitu&pd=1&source=1-101-1&idfrom=1&tbioswk=1");
                    return;
                }
                NestedScrollHeader.this.iIR = aVar.getRawBitmap();
                NestedScrollHeader.this.iIN.setImageBitmap(NestedScrollHeader.this.iIR);
                NestedScrollHeader.this.iIN.setTag(R.id.homepage_mission_entrance_url, missionEntranceUrl);
                NestedScrollHeader.this.iIN.invalidate();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onProgressUpdate(Object... objArr) {
                super.onProgressUpdate(objArr);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onCancelled(String str) {
                super.onCancelled(str);
            }
        }, null);
    }

    public void setEntranceJumpListener(a aVar) {
        this.iIQ = aVar;
    }

    public void setSearchHint(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.iIP.setText(str);
        }
    }

    public void aq(float f) {
        if (f >= 0.0f && f <= 1.0f) {
            if (this.iIN.getVisibility() == 0 && this.iIN.getAlpha() != f) {
                this.iIN.setAlpha(f);
            }
            if (this.iIP.getAlpha() != f) {
                this.iIP.setAlpha(f);
            }
        }
    }

    public void onChangeSkinType() {
        if (this.iIR == null) {
            ap.setImageResource(this.iIN, R.drawable.btn_home_task_n);
        } else if (this.iIN != null) {
            this.iIN.setImageBitmap(this.iIR);
        }
        ap.setViewTextColor(this.iIP, R.color.cp_cont_d);
        ap.setBackgroundResource(this.iIP, R.drawable.task_scroll_search_bg);
        this.iIP.setCompoundDrawablesWithIntrinsicBounds(SvgManager.bjq().a(R.drawable.icon_pure_search_import16_svg, R.color.cp_cont_d, (SvgManager.SvgResourceStateType) null), (Drawable) null, (Drawable) null, (Drawable) null);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.hAz);
        MessageManager.getInstance().registerListener(this.mSyncFinishListener);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.hAz);
        MessageManager.getInstance().unRegisterListener(this.mSyncFinishListener);
    }

    public ImageView getTaskView() {
        return this.iIN;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cww() {
        aq aqVar = new aq("c13422");
        aqVar.ai("obj_type", 2);
        aqVar.ai("obj_locate", 1);
        aqVar.ai("ab_tag", TbSingleton.getInstance().getHomePageStyleAbTest());
        aqVar.dD("obj_source", TbSingleton.getInstance().getMissionEntranceObjSource());
        TiebaStatic.log(aqVar);
    }
}
