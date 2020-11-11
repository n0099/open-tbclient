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
import com.baidu.tbadk.data.j;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class NestedScrollHeader extends RelativeLayout {
    CustomMessageListener ioV;
    View.OnClickListener jqH;
    private PublishButton jyC;
    private TbImageView jyD;
    private TextView jyE;
    private a jyF;
    private Bitmap jyG;
    private CustomMessageListener mSyncFinishListener;

    /* loaded from: classes22.dex */
    public interface a {
        void LJ(String str);
    }

    public NestedScrollHeader(@NonNull Context context) {
        this(context, null);
    }

    public NestedScrollHeader(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NestedScrollHeader(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jqH = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    if (NestedScrollHeader.this.jyD == view) {
                        Object tag = NestedScrollHeader.this.jyD.getTag(R.id.homepage_mission_entrance_url);
                        if (tag instanceof String) {
                            String str = (String) tag;
                            if (!TextUtils.isEmpty(str)) {
                                if (NestedScrollHeader.this.jyF != null) {
                                    NestedScrollHeader.this.jyF.LJ(str);
                                }
                                NestedScrollHeader.this.cJo();
                            }
                        }
                    } else if (NestedScrollHeader.this.jyE != view) {
                        if (NestedScrollHeader.this.jyC == view) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921452, new j(1)));
                            TiebaStatic.log(new aq("c13702").dR("uid", TbadkCoreApplication.getCurrentAccount()));
                        }
                    } else {
                        TiebaStatic.log(new aq(CommonStatisticKey.SEARCH_BAR_CLICK).al("obj_type", 1));
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new SquareSearchActivityConfig(NestedScrollHeader.this.getContext(), "", false)));
                    }
                } catch (Exception e) {
                }
            }
        };
        this.ioV = new CustomMessageListener(2921396) { // from class: com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader.4
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
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371 && NestedScrollHeader.this.jyD.getVisibility() == 0) {
                    NestedScrollHeader.this.cJn();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.layout_presenlize_scroll_header, (ViewGroup) this, true);
        this.jyC = (PublishButton) findViewById(R.id.publish_btn);
        this.jyD = (TbImageView) findViewById(R.id.task);
        this.jyE = (TextView) findViewById(R.id.search);
        this.jyC.setOnClickListener(this.jqH);
        this.jyD.setOnClickListener(this.jqH);
        this.jyE.setOnClickListener(this.jqH);
        MessageManager.getInstance().registerListener(this.ioV);
        MessageManager.getInstance().registerListener(this.mSyncFinishListener);
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
        cJn();
        onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cJn() {
        final String missionEntranceUrl = TbSingleton.getInstance().getMissionEntranceUrl();
        String missionEntranceIcon = TbSingleton.getInstance().getMissionEntranceIcon();
        if (TextUtils.isEmpty(missionEntranceUrl) || TextUtils.isEmpty(missionEntranceIcon)) {
            this.jyG = null;
            this.jyD.setTag(R.id.homepage_mission_entrance_url, "https://haokan.baidu.com/activity/h5/vault?productid=8&tab=act&tag=shitu&pd=1&source=1-101-1&idfrom=1&tbioswk=1");
            this.jyD.setImageResource(R.drawable.icon_mask_coin44);
            return;
        }
        c.mS().a(missionEntranceIcon, 10, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass2) aVar, str, i);
                if (aVar == null || aVar.getRawBitmap() == null || aVar.getRawBitmap().isRecycled()) {
                    NestedScrollHeader.this.jyG = null;
                    NestedScrollHeader.this.jyD.setImageResource(R.drawable.icon_mask_coin44);
                    NestedScrollHeader.this.jyD.setTag(R.id.homepage_mission_entrance_url, "https://haokan.baidu.com/activity/h5/vault?productid=8&tab=act&tag=shitu&pd=1&source=1-101-1&idfrom=1&tbioswk=1");
                    return;
                }
                NestedScrollHeader.this.jyG = aVar.getRawBitmap();
                NestedScrollHeader.this.jyD.setImageBitmap(NestedScrollHeader.this.jyG);
                NestedScrollHeader.this.jyD.setTag(R.id.homepage_mission_entrance_url, missionEntranceUrl);
                NestedScrollHeader.this.jyD.invalidate();
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
        this.jyF = aVar;
    }

    public void setSearchHint(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.jyE.setText(str);
        }
    }

    public void aA(float f) {
        if (f >= 0.0f && f <= 1.0f) {
            if (this.jyD.getVisibility() == 0 && this.jyD.getAlpha() != f) {
                this.jyD.setAlpha(f);
            }
            if (this.jyE.getAlpha() != f) {
                this.jyE.setAlpha(f);
            }
            if (this.jyC.getVisibility() == 0 && this.jyC.getAlpha() != f) {
                this.jyC.setAlpha(f);
                this.jyC.setScrollAlpha(f);
            }
        }
    }

    public void onChangeSkinType() {
        if (this.jyG == null) {
            ap.setImageResource(this.jyD, R.drawable.icon_mask_coin44);
        } else if (this.jyD != null) {
            this.jyD.setImageBitmap(this.jyG);
        }
        ap.setViewTextColor(this.jyE, R.color.cp_cont_d);
        ap.setBackgroundResource(this.jyE, R.drawable.task_scroll_search_bg);
        this.jyE.setCompoundDrawablesWithIntrinsicBounds(SvgManager.brn().a(R.drawable.icon_pure_search_import16_svg, R.color.cp_cont_d, (SvgManager.SvgResourceStateType) null), (Drawable) null, (Drawable) null, (Drawable) null);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.ioV);
        MessageManager.getInstance().registerListener(this.mSyncFinishListener);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.ioV);
        MessageManager.getInstance().unRegisterListener(this.mSyncFinishListener);
    }

    public ImageView getTaskView() {
        return this.jyD;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cJo() {
        aq aqVar = new aq("c13422");
        aqVar.al("obj_type", 2);
        aqVar.al("obj_locate", 1);
        aqVar.al("ab_tag", TbSingleton.getInstance().getHomePageStyleAbTest());
        aqVar.dR("obj_source", TbSingleton.getInstance().getMissionEntranceObjSource());
        TiebaStatic.log(aqVar);
    }
}
