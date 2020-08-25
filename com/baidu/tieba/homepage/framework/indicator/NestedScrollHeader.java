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
    CustomMessageListener hAt;
    View.OnClickListener iBT;
    private PublishButton iIG;
    private TbImageView iIH;
    private ImageView iII;
    private TextView iIJ;
    private a iIK;
    private Bitmap iIL;
    private CustomMessageListener mSyncFinishListener;

    /* loaded from: classes16.dex */
    public interface a {
        void JC(String str);
    }

    public NestedScrollHeader(@NonNull Context context) {
        this(context, null);
    }

    public NestedScrollHeader(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NestedScrollHeader(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iBT = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    if (NestedScrollHeader.this.iIH == view) {
                        Object tag = NestedScrollHeader.this.iIH.getTag(R.id.homepage_mission_entrance_url);
                        if (tag instanceof String) {
                            String str = (String) tag;
                            if (!TextUtils.isEmpty(str)) {
                                if (NestedScrollHeader.this.iIK != null) {
                                    NestedScrollHeader.this.iIK.JC(str);
                                }
                                NestedScrollHeader.this.cwv();
                            }
                        }
                    } else if (NestedScrollHeader.this.iIJ != view) {
                        if (NestedScrollHeader.this.iII != view) {
                            if (NestedScrollHeader.this.iIG == view) {
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
                        if (NestedScrollHeader.this.iIK != null) {
                            NestedScrollHeader.this.iIK.JC(missionEntranceUrl);
                        }
                    } else {
                        TiebaStatic.log(new aq(CommonStatisticKey.SEARCH_BAR_CLICK).ai("obj_type", 1));
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new SquareSearchActivityConfig(NestedScrollHeader.this.getContext(), "", false)));
                    }
                } catch (Exception e) {
                }
            }
        };
        this.hAt = new CustomMessageListener(2921396) { // from class: com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader.4
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
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371 && NestedScrollHeader.this.iIH.getVisibility() == 0) {
                    NestedScrollHeader.this.cwu();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.layout_presenlize_scroll_header, (ViewGroup) this, true);
        this.iIG = (PublishButton) findViewById(R.id.publish_btn);
        this.iIH = (TbImageView) findViewById(R.id.task);
        this.iII = (ImageView) findViewById(R.id.abtest_task);
        this.iIJ = (TextView) findViewById(R.id.search);
        this.iIG.setOnClickListener(this.iBT);
        this.iIH.setOnClickListener(this.iBT);
        this.iII.setOnClickListener(this.iBT);
        this.iIJ.setOnClickListener(this.iBT);
        MessageManager.getInstance().registerListener(this.hAt);
        MessageManager.getInstance().registerListener(this.mSyncFinishListener);
        this.iIG.setVisibility(8);
        this.iII.setVisibility(8);
        this.iIH.setVisibility(0);
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
        this.iIH.setVisibility(0);
        cwu();
        onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwu() {
        final String missionEntranceUrl = TbSingleton.getInstance().getMissionEntranceUrl();
        String missionEntranceIcon = TbSingleton.getInstance().getMissionEntranceIcon();
        if (TextUtils.isEmpty(missionEntranceUrl) || TextUtils.isEmpty(missionEntranceIcon)) {
            this.iIL = null;
            this.iIH.setTag(R.id.homepage_mission_entrance_url, "https://haokan.baidu.com/activity/h5/vault?productid=8&tab=act&tag=shitu&pd=1&source=1-101-1&idfrom=1&tbioswk=1");
            this.iIH.setImageResource(R.drawable.btn_home_task_n);
            return;
        }
        c.mM().a(missionEntranceIcon, 10, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass2) aVar, str, i);
                if (aVar == null || aVar.getRawBitmap() == null || aVar.getRawBitmap().isRecycled()) {
                    NestedScrollHeader.this.iIL = null;
                    NestedScrollHeader.this.iIH.setImageResource(R.drawable.btn_home_task_n);
                    NestedScrollHeader.this.iIH.setTag(R.id.homepage_mission_entrance_url, "https://haokan.baidu.com/activity/h5/vault?productid=8&tab=act&tag=shitu&pd=1&source=1-101-1&idfrom=1&tbioswk=1");
                    return;
                }
                NestedScrollHeader.this.iIL = aVar.getRawBitmap();
                NestedScrollHeader.this.iIH.setImageBitmap(NestedScrollHeader.this.iIL);
                NestedScrollHeader.this.iIH.setTag(R.id.homepage_mission_entrance_url, missionEntranceUrl);
                NestedScrollHeader.this.iIH.invalidate();
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
        this.iIK = aVar;
    }

    public void setSearchHint(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.iIJ.setText(str);
        }
    }

    public void aq(float f) {
        if (f >= 0.0f && f <= 1.0f) {
            if (this.iIH.getVisibility() == 0 && this.iIH.getAlpha() != f) {
                this.iIH.setAlpha(f);
            }
            if (this.iIJ.getAlpha() != f) {
                this.iIJ.setAlpha(f);
            }
        }
    }

    public void onChangeSkinType() {
        if (this.iIL == null) {
            ap.setImageResource(this.iIH, R.drawable.btn_home_task_n);
        } else if (this.iIH != null) {
            this.iIH.setImageBitmap(this.iIL);
        }
        ap.setViewTextColor(this.iIJ, R.color.cp_cont_d);
        ap.setBackgroundResource(this.iIJ, R.drawable.task_scroll_search_bg);
        this.iIJ.setCompoundDrawablesWithIntrinsicBounds(SvgManager.bjq().a(R.drawable.icon_pure_search_import16_svg, R.color.cp_cont_d, (SvgManager.SvgResourceStateType) null), (Drawable) null, (Drawable) null, (Drawable) null);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.hAt);
        MessageManager.getInstance().registerListener(this.mSyncFinishListener);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.hAt);
        MessageManager.getInstance().unRegisterListener(this.mSyncFinishListener);
    }

    public ImageView getTaskView() {
        return this.iIH;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwv() {
        aq aqVar = new aq("c13422");
        aqVar.ai("obj_type", 2);
        aqVar.ai("obj_locate", 1);
        aqVar.ai("ab_tag", TbSingleton.getInstance().getHomePageStyleAbTest());
        aqVar.dD("obj_source", TbSingleton.getInstance().getMissionEntranceObjSource());
        TiebaStatic.log(aqVar);
    }
}
