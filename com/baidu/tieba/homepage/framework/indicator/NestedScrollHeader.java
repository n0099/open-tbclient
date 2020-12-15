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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.data.k;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class NestedScrollHeader extends RelativeLayout {
    private float bcD;
    CustomMessageListener iAD;
    View.OnClickListener jEQ;
    private PublishButton jMX;
    private TbImageView jMY;
    private TextView jMZ;
    private a jNa;
    private Bitmap jNb;
    private CustomMessageListener mSyncFinishListener;

    /* loaded from: classes22.dex */
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
        this.bcD = 1.0f;
        this.jEQ = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    if (NestedScrollHeader.this.jMY == view) {
                        Object tag = NestedScrollHeader.this.jMY.getTag(R.id.homepage_mission_entrance_url);
                        if (tag instanceof String) {
                            String str = (String) tag;
                            if (!TextUtils.isEmpty(str)) {
                                if (NestedScrollHeader.this.jNa != null) {
                                    NestedScrollHeader.this.jNa.Mr(str);
                                }
                                NestedScrollHeader.this.cOj();
                            }
                        }
                    } else if (NestedScrollHeader.this.jMZ != view) {
                        if (NestedScrollHeader.this.jMX == view) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921452, new k(1)));
                            TiebaStatic.log(new ar("c13702").dY("uid", TbadkCoreApplication.getCurrentAccount()));
                        }
                    } else {
                        TiebaStatic.log(new ar(CommonStatisticKey.SEARCH_BAR_CLICK).al("obj_type", 1));
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new SquareSearchActivityConfig(NestedScrollHeader.this.getContext(), "", false)));
                    }
                } catch (Exception e) {
                }
            }
        };
        this.iAD = new CustomMessageListener(2921396) { // from class: com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader.4
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
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371 && NestedScrollHeader.this.jMY.getVisibility() == 0) {
                    NestedScrollHeader.this.cOi();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.layout_presenlize_scroll_header, (ViewGroup) this, true);
        this.jMX = (PublishButton) findViewById(R.id.publish_btn);
        this.jMY = (TbImageView) findViewById(R.id.task);
        this.jMZ = (TextView) findViewById(R.id.search);
        this.jMX.setOnClickListener(this.jEQ);
        this.jMY.setOnClickListener(this.jEQ);
        this.jMZ.setOnClickListener(this.jEQ);
        MessageManager.getInstance().registerListener(this.iAD);
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
        cOi();
        onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cOi() {
        final String missionEntranceUrl = TbSingleton.getInstance().getMissionEntranceUrl();
        String missionEntranceIcon = TbSingleton.getInstance().getMissionEntranceIcon();
        if (TextUtils.isEmpty(missionEntranceUrl) || TextUtils.isEmpty(missionEntranceIcon)) {
            this.jNb = null;
            this.jMY.setTag(R.id.homepage_mission_entrance_url, "https://haokan.baidu.com/activity/h5/vault?productid=8&tab=act&tag=shitu&pd=1&source=1-101-1&idfrom=1&tbioswk=1");
            this.jMY.setImageResource(R.drawable.icon_mask_coin44);
            return;
        }
        c.mS().a(missionEntranceIcon, 10, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass2) aVar, str, i);
                if (aVar == null || aVar.getRawBitmap() == null || aVar.getRawBitmap().isRecycled()) {
                    NestedScrollHeader.this.jNb = null;
                    NestedScrollHeader.this.jMY.setImageResource(R.drawable.icon_mask_coin44);
                    NestedScrollHeader.this.jMY.setTag(R.id.homepage_mission_entrance_url, "https://haokan.baidu.com/activity/h5/vault?productid=8&tab=act&tag=shitu&pd=1&source=1-101-1&idfrom=1&tbioswk=1");
                    return;
                }
                NestedScrollHeader.this.jNb = aVar.getRawBitmap();
                NestedScrollHeader.this.jMY.setImageBitmap(NestedScrollHeader.this.jNb);
                NestedScrollHeader.this.jMY.setTag(R.id.homepage_mission_entrance_url, missionEntranceUrl);
                NestedScrollHeader.this.jMY.invalidate();
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
        this.jNa = aVar;
    }

    public void setSearchHint(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.jMZ.setText(str);
        }
    }

    public void aI(float f) {
        if (f >= 0.0f && f <= 1.0f) {
            this.bcD = f;
            ap.a(this, R.color.CAM_X0208, 1.0f - f, TbadkCoreApplication.getInst().getSkinType());
            if (this.jMY.getVisibility() == 0 && this.jMY.getAlpha() != f) {
                this.jMY.setAlpha(f);
            }
            if (this.jMZ.getAlpha() != f) {
                this.jMZ.setAlpha(f);
            }
            if (this.jMX.getVisibility() == 0 && this.jMX.getAlpha() != f) {
                this.jMX.setAlpha(f);
                this.jMX.setScrollAlpha(f);
            }
        }
    }

    public void onChangeSkinType() {
        if (d.bkA()) {
            com.baidu.tbadk.core.elementsMaven.c.bm(this.jMZ).ps(R.color.CAM_X0109).pA(R.string.J_X01).setBackGroundColor(R.color.CAM_X0209);
        } else {
            com.baidu.tbadk.core.elementsMaven.c.bm(this.jMZ).ps(R.color.CAM_X0109).pA(R.string.J_X01).setBackGroundColor(R.color.CAM_X0210);
        }
        ap.a(this, R.color.CAM_X0208, 1.0f - this.bcD, TbadkCoreApplication.getInst().getSkinType());
        if (this.jNb == null) {
            ap.setImageResource(this.jMY, R.drawable.icon_mask_coin44);
        } else if (this.jMY != null) {
            this.jMY.setImageBitmap(this.jNb);
        }
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds42);
        Drawable a2 = WebPManager.a(R.drawable.icon_pure_search_import16, ap.getColor(R.color.CAM_X0109), WebPManager.ResourceStateType.NORMAL);
        a2.setBounds(0, 0, dimenPixelSize, dimenPixelSize);
        this.jMZ.setCompoundDrawables(a2, null, null, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.iAD);
        MessageManager.getInstance().registerListener(this.mSyncFinishListener);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.iAD);
        MessageManager.getInstance().unRegisterListener(this.mSyncFinishListener);
    }

    public ImageView getTaskView() {
        return this.jMY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cOj() {
        ar arVar = new ar("c13422");
        arVar.al("obj_type", 2);
        arVar.al("obj_locate", 1);
        arVar.al("ab_tag", TbSingleton.getInstance().getHomePageStyleAbTest());
        arVar.dY("obj_source", TbSingleton.getInstance().getMissionEntranceObjSource());
        TiebaStatic.log(arVar);
    }
}
