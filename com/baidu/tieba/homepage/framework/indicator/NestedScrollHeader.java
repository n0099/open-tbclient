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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.data.i;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class NestedScrollHeader extends RelativeLayout {
    CustomMessageListener hhS;
    View.OnClickListener ihJ;
    private PublishButton ion;
    private TbImageView ioo;
    private ImageView iop;
    private TextView ioq;
    private a ior;
    private Bitmap ios;
    private CustomMessageListener mSyncFinishListener;

    /* loaded from: classes9.dex */
    public interface a {
        void Ga(String str);
    }

    public NestedScrollHeader(@NonNull Context context) {
        this(context, null);
    }

    public NestedScrollHeader(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NestedScrollHeader(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ihJ = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    if (NestedScrollHeader.this.ioo == view) {
                        Object tag = NestedScrollHeader.this.ioo.getTag(R.id.homepage_mission_entrance_url);
                        if (tag instanceof String) {
                            String str = (String) tag;
                            if (!TextUtils.isEmpty(str)) {
                                if (NestedScrollHeader.this.ior != null) {
                                    NestedScrollHeader.this.ior.Ga(str);
                                }
                                NestedScrollHeader.this.cin();
                            }
                        }
                    } else if (NestedScrollHeader.this.ioq != view) {
                        if (NestedScrollHeader.this.iop != view) {
                            if (NestedScrollHeader.this.ion == view) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921452, new i(1)));
                                TiebaStatic.log(new ao("c13702").dk("uid", TbadkCoreApplication.getCurrentAccount()));
                                return;
                            }
                            return;
                        }
                        String missionEntranceUrl = TbSingleton.getInstance().getMissionEntranceUrl();
                        if (TextUtils.isEmpty(missionEntranceUrl)) {
                            missionEntranceUrl = "https://haokan.baidu.com/activity/h5/vault?productid=8&tab=act&tag=shitu&pd=1&source=1-101-1&idfrom=1&tbioswk=1";
                        }
                        if (NestedScrollHeader.this.ior != null) {
                            NestedScrollHeader.this.ior.Ga(missionEntranceUrl);
                        }
                    } else {
                        TiebaStatic.log(new ao(CommonStatisticKey.SEARCH_BAR_CLICK).ag("obj_type", 1));
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new SquareSearchActivityConfig(NestedScrollHeader.this.getContext(), "", false)));
                    }
                } catch (Exception e) {
                }
            }
        };
        this.hhS = new CustomMessageListener(2921396) { // from class: com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader.4
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
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371 && NestedScrollHeader.this.ioo.getVisibility() == 0) {
                    NestedScrollHeader.this.cim();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.layout_presenlize_scroll_header, (ViewGroup) this, true);
        this.ion = (PublishButton) findViewById(R.id.publish_btn);
        this.ioo = (TbImageView) findViewById(R.id.task);
        this.iop = (ImageView) findViewById(R.id.abtest_task);
        this.ioq = (TextView) findViewById(R.id.search);
        this.ion.setOnClickListener(this.ihJ);
        this.ioo.setOnClickListener(this.ihJ);
        this.iop.setOnClickListener(this.ihJ);
        this.ioq.setOnClickListener(this.ihJ);
        MessageManager.getInstance().registerListener(this.hhS);
        MessageManager.getInstance().registerListener(this.mSyncFinishListener);
        if (d.aNV()) {
            this.ion.setVisibility(0);
            this.iop.setVisibility(0);
            this.ioo.setVisibility(8);
        } else {
            this.ion.setVisibility(8);
            this.iop.setVisibility(8);
            this.ioo.setVisibility(0);
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
            this.ioo.setVisibility(0);
            cim();
        }
        onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cim() {
        if (!d.aNV()) {
            final String missionEntranceUrl = TbSingleton.getInstance().getMissionEntranceUrl();
            String missionEntranceIcon = TbSingleton.getInstance().getMissionEntranceIcon();
            if (TextUtils.isEmpty(missionEntranceUrl) || TextUtils.isEmpty(missionEntranceIcon)) {
                this.ios = null;
                this.ioo.setTag(R.id.homepage_mission_entrance_url, "https://haokan.baidu.com/activity/h5/vault?productid=8&tab=act&tag=shitu&pd=1&source=1-101-1&idfrom=1&tbioswk=1");
                this.ioo.setImageResource(R.drawable.btn_home_task_n);
                return;
            }
            c.ln().a(missionEntranceIcon, 10, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.e.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass2) aVar, str, i);
                    if (aVar == null || aVar.getRawBitmap() == null || aVar.getRawBitmap().isRecycled()) {
                        NestedScrollHeader.this.ios = null;
                        NestedScrollHeader.this.ioo.setImageResource(R.drawable.btn_home_task_n);
                        NestedScrollHeader.this.ioo.setTag(R.id.homepage_mission_entrance_url, "https://haokan.baidu.com/activity/h5/vault?productid=8&tab=act&tag=shitu&pd=1&source=1-101-1&idfrom=1&tbioswk=1");
                        return;
                    }
                    NestedScrollHeader.this.ios = aVar.getRawBitmap();
                    NestedScrollHeader.this.ioo.setImageBitmap(NestedScrollHeader.this.ios);
                    NestedScrollHeader.this.ioo.setTag(R.id.homepage_mission_entrance_url, missionEntranceUrl);
                    NestedScrollHeader.this.ioo.invalidate();
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
        this.ior = aVar;
    }

    public void setSearchHint(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.ioq.setText(str);
        }
    }

    public void ak(float f) {
        if (f >= 0.0f && f <= 1.0f) {
            if (this.ioo.getVisibility() == 0 && this.ioo.getAlpha() != f) {
                this.ioo.setAlpha(f);
            }
            if (this.ioq.getAlpha() != f) {
                this.ioq.setAlpha(f);
            }
        }
    }

    public void onChangeSkinType() {
        if (d.aNV()) {
            this.ion.aYj();
            SvgManager.aWQ().a(this.iop, R.drawable.ic_icon_pure_home_bar_game, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL);
        } else if (this.ios == null) {
            an.setImageResource(this.ioo, R.drawable.btn_home_task_n);
        } else if (this.ioo != null) {
            this.ioo.setImageBitmap(this.ios);
        }
        an.setViewTextColor(this.ioq, (int) R.color.cp_cont_d);
        an.setBackgroundResource(this.ioq, R.drawable.task_scroll_search_bg);
        this.ioq.setCompoundDrawablesWithIntrinsicBounds(SvgManager.aWQ().a(R.drawable.icon_pure_search_import16_svg, R.color.cp_cont_d, (SvgManager.SvgResourceStateType) null), (Drawable) null, (Drawable) null, (Drawable) null);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.hhS);
        MessageManager.getInstance().registerListener(this.mSyncFinishListener);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.hhS);
        MessageManager.getInstance().unRegisterListener(this.mSyncFinishListener);
    }

    public ImageView getTaskView() {
        return this.ioo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cin() {
        ao aoVar = new ao("c13422");
        aoVar.ag("obj_type", 2);
        aoVar.ag("obj_locate", 1);
        aoVar.ag("ab_tag", TbSingleton.getInstance().getHomePageStyleAbTest());
        aoVar.dk("obj_source", TbSingleton.getInstance().getMissionEntranceObjSource());
        TiebaStatic.log(aoVar);
    }
}
