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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.data.k;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.google.android.material.appbar.AppBarLayout;
/* loaded from: classes2.dex */
public class NestedScrollHeader extends RelativeLayout {
    private float alpha;
    CustomMessageListener iPN;
    View.OnClickListener jXv;
    private TextView kfA;
    private a kfB;
    private Bitmap kfC;
    private PublishButton kfy;
    private TbImageView kfz;
    private CustomMessageListener mSyncFinishListener;

    /* loaded from: classes2.dex */
    public interface a {
        void Ma(String str);
    }

    public NestedScrollHeader(@NonNull Context context) {
        this(context, null);
    }

    public NestedScrollHeader(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NestedScrollHeader(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.alpha = 1.0f;
        this.jXv = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    if (NestedScrollHeader.this.kfz == view) {
                        Object tag = NestedScrollHeader.this.kfz.getTag(R.id.homepage_mission_entrance_url);
                        if (tag instanceof String) {
                            String str = (String) tag;
                            if (!TextUtils.isEmpty(str)) {
                                if (NestedScrollHeader.this.kfB != null) {
                                    NestedScrollHeader.this.kfB.Ma(str);
                                }
                                NestedScrollHeader.this.cPI();
                            }
                        }
                    } else if (NestedScrollHeader.this.kfA != view) {
                        if (NestedScrollHeader.this.kfy == view && !WriteActivityConfig.isAsyncWriting()) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921452, new k(1)));
                            TiebaStatic.log(new ar("c13702").dR("uid", TbadkCoreApplication.getCurrentAccount()));
                        }
                    } else {
                        TiebaStatic.log(new ar(CommonStatisticKey.SEARCH_BAR_CLICK).aq("obj_type", 1));
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new SquareSearchActivityConfig(NestedScrollHeader.this.getContext(), "", false)));
                    }
                } catch (Exception e) {
                }
            }
        };
        this.iPN = new CustomMessageListener(2921396) { // from class: com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader.4
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
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371 && NestedScrollHeader.this.kfz.getVisibility() == 0) {
                    NestedScrollHeader.this.cPH();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.layout_presenlize_scroll_header, (ViewGroup) this, true);
        this.kfy = (PublishButton) findViewById(R.id.publish_btn);
        this.kfz = (TbImageView) findViewById(R.id.task);
        this.kfA = (TextView) findViewById(R.id.search);
        this.kfy.setOnClickListener(this.jXv);
        this.kfz.setOnClickListener(this.jXv);
        this.kfA.setOnClickListener(this.jXv);
        MessageManager.getInstance().registerListener(this.iPN);
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
        cPH();
        onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cPH() {
        final String missionEntranceUrl = TbSingleton.getInstance().getMissionEntranceUrl();
        String missionEntranceIcon = TbSingleton.getInstance().getMissionEntranceIcon();
        if (TextUtils.isEmpty(missionEntranceUrl) || TextUtils.isEmpty(missionEntranceIcon)) {
            this.kfC = null;
            this.kfz.setTag(R.id.homepage_mission_entrance_url, "https://haokan.baidu.com/activity/h5/vault?productid=8&tab=act&tag=shitu&pd=1&source=1-101-1&idfrom=1&tbioswk=1");
            this.kfz.setImageResource(R.drawable.icon_mask_coin44);
            return;
        }
        d.mw().a(missionEntranceIcon, 10, new c<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.c
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass2) aVar, str, i);
                if (aVar == null || aVar.getRawBitmap() == null || aVar.getRawBitmap().isRecycled()) {
                    NestedScrollHeader.this.kfC = null;
                    NestedScrollHeader.this.kfz.setImageResource(R.drawable.icon_mask_coin44);
                    NestedScrollHeader.this.kfz.setTag(R.id.homepage_mission_entrance_url, "https://haokan.baidu.com/activity/h5/vault?productid=8&tab=act&tag=shitu&pd=1&source=1-101-1&idfrom=1&tbioswk=1");
                    return;
                }
                NestedScrollHeader.this.kfC = aVar.getRawBitmap();
                NestedScrollHeader.this.kfz.setImageBitmap(NestedScrollHeader.this.kfC);
                NestedScrollHeader.this.kfz.setTag(R.id.homepage_mission_entrance_url, missionEntranceUrl);
                NestedScrollHeader.this.kfz.invalidate();
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
        this.kfB = aVar;
    }

    public void setSearchHint(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.kfA.setText(str);
        }
    }

    public void aR(float f) {
        if (f >= 0.0f && f <= 1.0f) {
            this.alpha = f;
            ap.a(this, R.color.CAM_X0208, 1.0f - f, TbadkCoreApplication.getInst().getSkinType());
            if (this.kfz.getVisibility() == 0 && this.kfz.getAlpha() != f) {
                this.kfz.setAlpha(f);
            }
            if (this.kfA.getAlpha() != f) {
                this.kfA.setAlpha(f);
            }
            if (this.kfy.getVisibility() == 0 && this.kfy.getAlpha() != f) {
                this.kfy.setAlpha(f);
                this.kfy.setScrollAlpha(f);
            }
        }
    }

    public void onChangeSkinType() {
        com.baidu.tbadk.core.elementsMaven.c.br(this.kfA).nZ(R.color.CAM_X0109).oh(R.string.J_X01).setBackGroundColor(R.color.CAM_X0210);
        ap.a(this, R.color.CAM_X0208, 1.0f - this.alpha, TbadkCoreApplication.getInst().getSkinType());
        if (this.kfC == null) {
            ap.setImageResource(this.kfz, R.drawable.icon_mask_coin44);
        } else if (this.kfz != null) {
            this.kfz.setImageBitmap(this.kfC);
        }
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds42);
        Drawable a2 = WebPManager.a(R.drawable.icon_pure_search_import16, ap.getColor(R.color.CAM_X0109), WebPManager.ResourceStateType.NORMAL);
        a2.setBounds(0, 0, dimenPixelSize, dimenPixelSize);
        this.kfA.setCompoundDrawables(a2, null, null, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.iPN);
        MessageManager.getInstance().registerListener(this.mSyncFinishListener);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.iPN);
        MessageManager.getInstance().unRegisterListener(this.mSyncFinishListener);
    }

    public ImageView getTaskView() {
        return this.kfz;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cPI() {
        ar arVar = new ar("c13422");
        arVar.aq("obj_type", 2);
        arVar.aq("obj_locate", 1);
        arVar.aq("ab_tag", TbSingleton.getInstance().getHomePageStyleAbTest());
        arVar.dR("obj_source", TbSingleton.getInstance().getMissionEntranceObjSource());
        TiebaStatic.log(arVar);
    }
}
