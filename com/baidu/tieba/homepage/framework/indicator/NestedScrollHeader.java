package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.atomData.SquareSearchActivityConfig;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.switchs.MissionEntranceSwitch;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class NestedScrollHeader extends RelativeLayout {
    CustomMessageListener gGk;
    View.OnClickListener hDJ;
    private TbImageView hKv;
    private TextView hKw;
    private a hKx;
    private Bitmap hKy;
    private CustomMessageListener mSyncFinishListener;

    /* loaded from: classes9.dex */
    public interface a {
        void DO(String str);
    }

    public NestedScrollHeader(@NonNull Context context) {
        this(context, null);
    }

    public NestedScrollHeader(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NestedScrollHeader(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hDJ = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (NestedScrollHeader.this.hKv == view) {
                    Object tag = NestedScrollHeader.this.hKv.getTag(R.id.homepage_mission_entrance_url);
                    if (tag instanceof String) {
                        String str = (String) tag;
                        if (!TextUtils.isEmpty(str)) {
                            if (NestedScrollHeader.this.hKx != null) {
                                NestedScrollHeader.this.hKx.DO(str);
                            }
                            NestedScrollHeader.this.bYp();
                        }
                    }
                } else if (NestedScrollHeader.this.hKw == view) {
                    TiebaStatic.log(new an(CommonStatisticKey.SEARCH_BAR_CLICK).af("obj_type", 1));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new SquareSearchActivityConfig(NestedScrollHeader.this.getContext(), "", false)));
                }
            }
        };
        this.gGk = new CustomMessageListener(2921396) { // from class: com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                NestedScrollHeader.this.setSearchHint(TbSingleton.getInstance().getHotSearch());
            }
        };
        this.mSyncFinishListener = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371 && NestedScrollHeader.this.hKv.getVisibility() == 0) {
                    NestedScrollHeader.this.bYo();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.layout_presenlize_scroll_header, (ViewGroup) this, true);
        this.hKv = (TbImageView) findViewById(R.id.task);
        this.hKv.setOnClickListener(this.hDJ);
        this.hKw = (TextView) findViewById(R.id.search);
        this.hKw.setOnClickListener(this.hDJ);
        onChangeSkinType();
        MessageManager.getInstance().registerListener(this.gGk);
        MessageManager.getInstance().registerListener(this.mSyncFinishListener);
        if (MissionEntranceSwitch.isOn()) {
            this.hKv.setVisibility(0);
            bYo();
            return;
        }
        this.hKv.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYo() {
        final String missionEntranceUrl = TbSingleton.getInstance().getMissionEntranceUrl();
        String missionEntranceIcon = TbSingleton.getInstance().getMissionEntranceIcon();
        if (TextUtils.isEmpty(missionEntranceUrl) || TextUtils.isEmpty(missionEntranceIcon)) {
            this.hKy = null;
            this.hKv.setTag(R.id.homepage_mission_entrance_url, "https://haokan.baidu.com/activity/h5/vault?productid=8&tab=act&tag=shitu&pd=1&source=1-101-1&idfrom=1&tbioswk=1");
            this.hKv.setImageResource(R.drawable.btn_home_task_n);
            return;
        }
        c.kV().a(missionEntranceIcon, 10, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass1) aVar, str, i);
                if (aVar == null || aVar.getRawBitmap() == null || aVar.getRawBitmap().isRecycled()) {
                    NestedScrollHeader.this.hKy = null;
                    NestedScrollHeader.this.hKv.setImageResource(R.drawable.btn_home_task_n);
                    NestedScrollHeader.this.hKv.setTag(R.id.homepage_mission_entrance_url, "https://haokan.baidu.com/activity/h5/vault?productid=8&tab=act&tag=shitu&pd=1&source=1-101-1&idfrom=1&tbioswk=1");
                    return;
                }
                NestedScrollHeader.this.hKy = aVar.getRawBitmap();
                NestedScrollHeader.this.hKv.setImageBitmap(NestedScrollHeader.this.hKy);
                NestedScrollHeader.this.hKv.setTag(R.id.homepage_mission_entrance_url, missionEntranceUrl);
                NestedScrollHeader.this.hKv.invalidate();
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
        this.hKx = aVar;
    }

    public void setSearchHint(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.hKw.setText(str);
        }
    }

    public void ai(float f) {
        if (f >= 0.0f && f <= 1.0f) {
            if (this.hKv.getVisibility() == 0 && this.hKv.getAlpha() != f) {
                this.hKv.setAlpha(f);
            }
            if (this.hKw.getAlpha() != f) {
                this.hKw.setAlpha(f);
            }
        }
    }

    public void onChangeSkinType() {
        am.setViewTextColor(this.hKw, (int) R.color.cp_cont_d);
        am.setBackgroundResource(this.hKw, R.drawable.task_scroll_search_bg);
        this.hKw.setCompoundDrawablesWithIntrinsicBounds(SvgManager.aOU().a(R.drawable.icon_pure_search_import16_svg, R.color.cp_cont_d, (SvgManager.SvgResourceStateType) null), (Drawable) null, (Drawable) null, (Drawable) null);
        if (this.hKy == null) {
            am.setImageResource(this.hKv, R.drawable.btn_home_task_n);
        } else if (this.hKv != null) {
            this.hKv.setImageBitmap(this.hKy);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.gGk);
        MessageManager.getInstance().registerListener(this.mSyncFinishListener);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.gGk);
        MessageManager.getInstance().unRegisterListener(this.mSyncFinishListener);
    }

    public ImageView getTaskView() {
        return this.hKv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYp() {
        an anVar = new an("c13422");
        anVar.af("obj_type", 2);
        anVar.af("obj_locate", 1);
        anVar.af(TiebaInitialize.Params.AB_TAG, TbSingleton.getInstance().getHomePageStyleAbTest());
        TiebaStatic.log(anVar);
    }
}
