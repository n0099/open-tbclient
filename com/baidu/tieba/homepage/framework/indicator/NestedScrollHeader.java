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
import com.baidu.tbadk.a.d;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SquareSearchActivityConfig;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.data.i;
import com.baidu.tbadk.switchs.MissionEntranceSwitch;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class NestedScrollHeader extends RelativeLayout {
    CustomMessageListener gUY;
    View.OnClickListener hSC;
    private PublishButton hYZ;
    private TbImageView hZa;
    private ImageView hZb;
    private TextView hZc;
    private a hZd;
    private Bitmap hZe;
    private CustomMessageListener mSyncFinishListener;

    /* loaded from: classes9.dex */
    public interface a {
        void FA(String str);
    }

    public NestedScrollHeader(@NonNull Context context) {
        this(context, null);
    }

    public NestedScrollHeader(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NestedScrollHeader(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hSC = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    if (NestedScrollHeader.this.hZa == view) {
                        Object tag = NestedScrollHeader.this.hZa.getTag(R.id.homepage_mission_entrance_url);
                        if (tag instanceof String) {
                            String str = (String) tag;
                            if (!TextUtils.isEmpty(str)) {
                                if (NestedScrollHeader.this.hZd != null) {
                                    NestedScrollHeader.this.hZd.FA(str);
                                }
                                NestedScrollHeader.this.ceJ();
                            }
                        }
                    } else if (NestedScrollHeader.this.hZc != view) {
                        if (NestedScrollHeader.this.hZb != view) {
                            if (NestedScrollHeader.this.hYZ == view) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921452, new i(1)));
                                TiebaStatic.log(new an("c13702").dh("uid", TbadkCoreApplication.getCurrentAccount()));
                                return;
                            }
                            return;
                        }
                        String missionEntranceUrl = TbSingleton.getInstance().getMissionEntranceUrl();
                        if (TextUtils.isEmpty(missionEntranceUrl)) {
                            missionEntranceUrl = "https://haokan.baidu.com/activity/h5/vault?productid=8&tab=act&tag=shitu&pd=1&source=1-101-1&idfrom=1&tbioswk=1";
                        }
                        if (NestedScrollHeader.this.hZd != null) {
                            NestedScrollHeader.this.hZd.FA(missionEntranceUrl);
                        }
                    } else {
                        TiebaStatic.log(new an(CommonStatisticKey.SEARCH_BAR_CLICK).ag("obj_type", 1));
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new SquareSearchActivityConfig(NestedScrollHeader.this.getContext(), "", false)));
                    }
                } catch (Exception e) {
                }
            }
        };
        this.gUY = new CustomMessageListener(2921396) { // from class: com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader.4
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
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371 && NestedScrollHeader.this.hZa.getVisibility() == 0) {
                    NestedScrollHeader.this.ceI();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.layout_presenlize_scroll_header, (ViewGroup) this, true);
        this.hYZ = (PublishButton) findViewById(R.id.publish_btn);
        this.hZa = (TbImageView) findViewById(R.id.task);
        this.hZb = (ImageView) findViewById(R.id.abtest_task);
        this.hZc = (TextView) findViewById(R.id.search);
        this.hYZ.setOnClickListener(this.hSC);
        this.hZa.setOnClickListener(this.hSC);
        this.hZb.setOnClickListener(this.hSC);
        this.hZc.setOnClickListener(this.hSC);
        MessageManager.getInstance().registerListener(this.gUY);
        MessageManager.getInstance().registerListener(this.mSyncFinishListener);
        if (d.aMs()) {
            this.hYZ.setVisibility(0);
            this.hZb.setVisibility(0);
            this.hZa.setVisibility(8);
        } else {
            this.hYZ.setVisibility(8);
            this.hZb.setVisibility(8);
            this.hZa.setVisibility(0);
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
            if (MissionEntranceSwitch.isOn()) {
                this.hZa.setVisibility(0);
                ceI();
            } else {
                this.hZa.setVisibility(8);
            }
        }
        onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ceI() {
        if (!d.aMs()) {
            final String missionEntranceUrl = TbSingleton.getInstance().getMissionEntranceUrl();
            String missionEntranceIcon = TbSingleton.getInstance().getMissionEntranceIcon();
            if (TextUtils.isEmpty(missionEntranceUrl) || TextUtils.isEmpty(missionEntranceIcon)) {
                this.hZe = null;
                this.hZa.setTag(R.id.homepage_mission_entrance_url, "https://haokan.baidu.com/activity/h5/vault?productid=8&tab=act&tag=shitu&pd=1&source=1-101-1&idfrom=1&tbioswk=1");
                this.hZa.setImageResource(R.drawable.btn_home_task_n);
                return;
            }
            c.kX().a(missionEntranceIcon, 10, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.e.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass2) aVar, str, i);
                    if (aVar == null || aVar.getRawBitmap() == null || aVar.getRawBitmap().isRecycled()) {
                        NestedScrollHeader.this.hZe = null;
                        NestedScrollHeader.this.hZa.setImageResource(R.drawable.btn_home_task_n);
                        NestedScrollHeader.this.hZa.setTag(R.id.homepage_mission_entrance_url, "https://haokan.baidu.com/activity/h5/vault?productid=8&tab=act&tag=shitu&pd=1&source=1-101-1&idfrom=1&tbioswk=1");
                        return;
                    }
                    NestedScrollHeader.this.hZe = aVar.getRawBitmap();
                    NestedScrollHeader.this.hZa.setImageBitmap(NestedScrollHeader.this.hZe);
                    NestedScrollHeader.this.hZa.setTag(R.id.homepage_mission_entrance_url, missionEntranceUrl);
                    NestedScrollHeader.this.hZa.invalidate();
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
    }

    public void setEntranceJumpListener(a aVar) {
        this.hZd = aVar;
    }

    public void setSearchHint(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.hZc.setText(str);
        }
    }

    public void ag(float f) {
        if (f >= 0.0f && f <= 1.0f) {
            if (this.hZa.getVisibility() == 0 && this.hZa.getAlpha() != f) {
                this.hZa.setAlpha(f);
            }
            if (this.hZc.getAlpha() != f) {
                this.hZc.setAlpha(f);
            }
        }
    }

    public void onChangeSkinType() {
        if (d.aMs()) {
            this.hYZ.aWq();
            SvgManager.aUV().a(this.hZb, R.drawable.ic_icon_pure_home_bar_game, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL);
        } else if (this.hZe == null) {
            am.setImageResource(this.hZa, R.drawable.btn_home_task_n);
        } else if (this.hZa != null) {
            this.hZa.setImageBitmap(this.hZe);
        }
        am.setViewTextColor(this.hZc, (int) R.color.cp_cont_d);
        am.setBackgroundResource(this.hZc, R.drawable.task_scroll_search_bg);
        this.hZc.setCompoundDrawablesWithIntrinsicBounds(SvgManager.aUV().a(R.drawable.icon_pure_search_import16_svg, R.color.cp_cont_d, (SvgManager.SvgResourceStateType) null), (Drawable) null, (Drawable) null, (Drawable) null);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.gUY);
        MessageManager.getInstance().registerListener(this.mSyncFinishListener);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.gUY);
        MessageManager.getInstance().unRegisterListener(this.mSyncFinishListener);
    }

    public ImageView getTaskView() {
        return this.hZa;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ceJ() {
        an anVar = new an("c13422");
        anVar.ag("obj_type", 2);
        anVar.ag("obj_locate", 1);
        anVar.ag("ab_tag", TbSingleton.getInstance().getHomePageStyleAbTest());
        TiebaStatic.log(anVar);
    }
}
