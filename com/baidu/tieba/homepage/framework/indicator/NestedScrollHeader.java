package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.e.c;
import com.baidu.adp.lib.e.d;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SquareSearchActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.data.k;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.google.android.material.appbar.AppBarLayout;
/* loaded from: classes2.dex */
public class NestedScrollHeader extends RelativeLayout {
    private float bem;
    CustomMessageListener iMP;
    View.OnClickListener jSi;
    private PublishButton kal;
    private TbImageView kam;
    private TextView kan;
    private a kao;
    private Bitmap kap;
    private CustomMessageListener mSyncFinishListener;

    /* loaded from: classes2.dex */
    public interface a {
        void Mr(String str);
    }

    public NestedScrollHeader(@NonNull Context context) {
        this(context, null);
    }

    public NestedScrollHeader(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NestedScrollHeader(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bem = 1.0f;
        this.jSi = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    if (NestedScrollHeader.this.kam == view) {
                        Object tag = NestedScrollHeader.this.kam.getTag(R.id.homepage_mission_entrance_url);
                        if (tag instanceof String) {
                            String str = (String) tag;
                            if (!TextUtils.isEmpty(str)) {
                                if (NestedScrollHeader.this.kao != null) {
                                    NestedScrollHeader.this.kao.Mr(str);
                                }
                                NestedScrollHeader.this.cRp();
                            }
                        }
                    } else if (NestedScrollHeader.this.kan != view) {
                        if (NestedScrollHeader.this.kal == view && !WriteActivityConfig.isAsyncWriting()) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921452, new k(1)));
                            TiebaStatic.log(new aq("c13702").dX("uid", TbadkCoreApplication.getCurrentAccount()));
                        }
                    } else {
                        TiebaStatic.log(new aq(CommonStatisticKey.SEARCH_BAR_CLICK).an("obj_type", 1));
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new SquareSearchActivityConfig(NestedScrollHeader.this.getContext(), "", false)));
                    }
                } catch (Exception e) {
                }
            }
        };
        this.iMP = new CustomMessageListener(2921396) { // from class: com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader.4
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
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371 && NestedScrollHeader.this.kam.getVisibility() == 0) {
                    NestedScrollHeader.this.cRo();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.layout_presenlize_scroll_header, (ViewGroup) this, true);
        this.kal = (PublishButton) findViewById(R.id.publish_btn);
        this.kam = (TbImageView) findViewById(R.id.task);
        this.kan = (TextView) findViewById(R.id.search);
        this.kal.setOnClickListener(this.jSi);
        this.kam.setOnClickListener(this.jSi);
        this.kan.setOnClickListener(this.jSi);
        MessageManager.getInstance().registerListener(this.iMP);
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
        cRo();
        onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cRo() {
        final String missionEntranceUrl = TbSingleton.getInstance().getMissionEntranceUrl();
        String missionEntranceIcon = TbSingleton.getInstance().getMissionEntranceIcon();
        if (TextUtils.isEmpty(missionEntranceUrl) || TextUtils.isEmpty(missionEntranceIcon)) {
            this.kap = null;
            this.kam.setTag(R.id.homepage_mission_entrance_url, "https://haokan.baidu.com/activity/h5/vault?productid=8&tab=act&tag=shitu&pd=1&source=1-101-1&idfrom=1&tbioswk=1");
            this.kam.setImageResource(R.drawable.icon_mask_coin44);
            return;
        }
        d.mx().a(missionEntranceIcon, 10, new c<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.c
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass2) aVar, str, i);
                if (aVar == null || aVar.getRawBitmap() == null || aVar.getRawBitmap().isRecycled()) {
                    NestedScrollHeader.this.kap = null;
                    NestedScrollHeader.this.kam.setImageResource(R.drawable.icon_mask_coin44);
                    NestedScrollHeader.this.kam.setTag(R.id.homepage_mission_entrance_url, "https://haokan.baidu.com/activity/h5/vault?productid=8&tab=act&tag=shitu&pd=1&source=1-101-1&idfrom=1&tbioswk=1");
                    return;
                }
                NestedScrollHeader.this.kap = aVar.getRawBitmap();
                NestedScrollHeader.this.kam.setImageBitmap(NestedScrollHeader.this.kap);
                NestedScrollHeader.this.kam.setTag(R.id.homepage_mission_entrance_url, missionEntranceUrl);
                NestedScrollHeader.this.kam.invalidate();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.c
            public void onProgressUpdate(Object... objArr) {
                super.onProgressUpdate(objArr);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.c
            public void onCancelled(String str) {
                super.onCancelled(str);
            }
        }, null);
    }

    public void setEntranceJumpListener(a aVar) {
        this.kao = aVar;
    }

    public void setSearchHint(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.kan.setText(str);
        }
    }

    public void aK(float f) {
        if (f >= 0.0f && f <= 1.0f) {
            this.bem = f;
            ao.a(this, R.color.CAM_X0208, 1.0f - f, TbadkCoreApplication.getInst().getSkinType());
            if (this.kam.getVisibility() == 0 && this.kam.getAlpha() != f) {
                this.kam.setAlpha(f);
            }
            if (this.kan.getAlpha() != f) {
                this.kan.setAlpha(f);
            }
            if (this.kal.getVisibility() == 0 && this.kal.getAlpha() != f) {
                this.kal.setAlpha(f);
                this.kal.setScrollAlpha(f);
            }
        }
    }

    public void onChangeSkinType() {
        com.baidu.tbadk.core.elementsMaven.c.bv(this.kan).pC(R.color.CAM_X0109).pK(R.string.J_X01).setBackGroundColor(R.color.CAM_X0210);
        ao.a(this, R.color.CAM_X0208, 1.0f - this.bem, TbadkCoreApplication.getInst().getSkinType());
        if (this.kap == null) {
            ao.setImageResource(this.kam, R.drawable.icon_mask_coin44);
        } else if (this.kam != null) {
            this.kam.setImageBitmap(this.kap);
        }
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds42);
        Drawable a2 = WebPManager.a(R.drawable.icon_pure_search_import16, ao.getColor(R.color.CAM_X0109), WebPManager.ResourceStateType.NORMAL);
        a2.setBounds(0, 0, dimenPixelSize, dimenPixelSize);
        this.kan.setCompoundDrawables(a2, null, null, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.iMP);
        MessageManager.getInstance().registerListener(this.mSyncFinishListener);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.iMP);
        MessageManager.getInstance().unRegisterListener(this.mSyncFinishListener);
    }

    public ImageView getTaskView() {
        return this.kam;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cRp() {
        aq aqVar = new aq("c13422");
        aqVar.an("obj_type", 2);
        aqVar.an("obj_locate", 1);
        aqVar.an("ab_tag", TbSingleton.getInstance().getHomePageStyleAbTest());
        aqVar.dX("obj_source", TbSingleton.getInstance().getMissionEntranceObjSource());
        TiebaStatic.log(aqVar);
    }
}
