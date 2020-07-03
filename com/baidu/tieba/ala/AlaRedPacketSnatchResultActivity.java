package com.baidu.tieba.ala;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.adp.widget.listview.BdListView;
import com.baidu.live.data.w;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.BaseFragmentActivity;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.utils.h;
import com.baidu.tieba.ala.data.d;
import com.baidu.tieba.ala.f.k;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class AlaRedPacketSnatchResultActivity extends BaseFragmentActivity {
    private HeadImageView aTd;
    private String aZa;
    private FrameLayout bMW;
    private TextView dEL;
    private View fdW;
    private LinearLayout fdX;
    private TextView ffr;
    private TextView ffs;
    private TextView fft;
    private BdListView ffu;
    private a ffv;
    private com.baidu.tieba.ala.data.d ffw;
    private com.baidu.tieba.ala.f.e ffx;
    private CustomMessageListener ffy = new CustomMessageListener(2913129) { // from class: com.baidu.tieba.ala.AlaRedPacketSnatchResultActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaRedPacketSnatchResultActivity.this.finish();
        }
    };
    private k ffz = new k() { // from class: com.baidu.tieba.ala.AlaRedPacketSnatchResultActivity.2
        @Override // com.baidu.tieba.ala.f.k
        public void b(com.baidu.tieba.ala.data.d dVar) {
            AlaRedPacketSnatchResultActivity.this.a(dVar);
        }

        @Override // com.baidu.tieba.ala.f.k
        public void az(int i, String str) {
            AlaRedPacketSnatchResultActivity.this.showToast(a.i.sdk_net_fail_tip);
        }
    };
    private ImageView mCloseBtn;
    private String mLiveId;
    private String mRedPacketId;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        setUseStyleImmersiveSticky(true);
        super.onCreate(bundle);
        if (!isFinishing()) {
            if (getIntent() == null) {
                finish();
                return;
            }
            parserIntent();
            if (StringUtils.isNullObject(this.mRedPacketId)) {
                finish();
                return;
            }
            String str = Build.DISPLAY;
            if (str != null && str.contains("Flyme")) {
                getWindow().setBackgroundDrawable(new ColorDrawable(getResources().getColor(a.d.sdk_transparent)));
            }
            setContentView(a.h.ala_red_packet_snatch_result_view);
            initView();
            this.ffx = new com.baidu.tieba.ala.f.e(getPageContext(), this.ffz);
            this.ffx.ai(this.mRedPacketId, this.mLiveId, this.aZa);
            MessageManager.getInstance().registerListener(this.ffy);
            jq(UtilHelper.getRealScreenOrientation(this) == 2);
        }
    }

    private void parserIntent() {
        this.mRedPacketId = getIntent().getStringExtra("red_packet_id");
        this.mLiveId = getIntent().getStringExtra("live_id");
        this.aZa = getIntent().getStringExtra("anchor_id");
    }

    private void initView() {
        this.fdW = findViewById(a.g.rp_result_root_bg);
        this.fdW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaRedPacketSnatchResultActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
                    AlaRedPacketSnatchResultActivity.this.finish();
                }
            }
        });
        this.mCloseBtn = (ImageView) findViewById(a.g.rp_result_close_btn);
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.mCloseBtn.setVisibility(0);
            this.mCloseBtn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaRedPacketSnatchResultActivity.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AlaRedPacketSnatchResultActivity.this.finish();
                }
            });
        } else {
            this.mCloseBtn.setVisibility(8);
        }
        this.bMW = (FrameLayout) findViewById(a.g.rp_result_root_container);
        this.aTd = (HeadImageView) findViewById(a.g.rp_result_user_icon);
        this.aTd.setBorderWidth(BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.e.sdk_ds6));
        this.aTd.setBorderColor(getPageContext().getResources().getColor(a.d.ala_red_packet_main_color));
        this.aTd.setIsRound(true);
        this.aTd.setDefaultResource(a.f.sdk_icon_default_avatar100_bg);
        this.aTd.setAutoChangeStyle(true);
        this.aTd.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.ffr = (TextView) findViewById(a.g.p_result_top10_desc);
        this.dEL = (TextView) findViewById(a.g.p_result_user_name);
        this.ffs = (TextView) findViewById(a.g.p_result_loot_amount);
        this.fdX = (LinearLayout) findViewById(a.g.rp_result_content);
        this.fft = (TextView) findViewById(a.g.p_result_send_gift);
        this.ffu = (BdListView) findViewById(a.g.p_result_listview);
        this.fft.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaRedPacketSnatchResultActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaRedPacketSnatchResultActivity.this.finish();
                AlaRedPacketSnatchResultActivity.this.brJ();
            }
        });
        this.fdX.setVisibility(8);
        this.fft.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brJ() {
        w wVar = new w();
        wVar.ayb = -1;
        wVar.ayc = -1;
        wVar.aye = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, wVar));
    }

    public void a(com.baidu.tieba.ala.data.d dVar) {
        String str;
        this.ffw = dVar;
        this.fdX.setVisibility(0);
        this.fft.setVisibility(0);
        if (!StringUtils.isNullObject(dVar.portrait)) {
            com.baidu.live.utils.k.a(this.aTd, dVar.portrait, true, false);
        }
        this.dEL.setText(dVar.userName);
        if (dVar.fDO) {
            String format = String.format(getPageContext().getResources().getString(a.i.snatch_red_packet_amount_desc), Long.valueOf(dVar.fDw));
            this.fft.setVisibility(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fdX.getLayoutParams();
            layoutParams.bottomMargin = getPageContext().getResources().getDimensionPixelSize(a.e.sdk_ds184);
            this.fdX.setLayoutParams(layoutParams);
            str = format;
        } else {
            String string = getPageContext().getResources().getString(a.i.snatch_red_packet_failed_1);
            this.fft.setVisibility(8);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.fdX.getLayoutParams();
            layoutParams2.bottomMargin = getPageContext().getResources().getDimensionPixelSize(a.e.sdk_ds50);
            this.fdX.setLayoutParams(layoutParams2);
            str = string;
        }
        this.ffs.setText(str);
        P(dVar.fDP);
    }

    private void P(ArrayList<d.a> arrayList) {
        this.ffv = new a(getPageContext().getPageActivity(), arrayList);
        this.ffu.setAdapter((ListAdapter) this.ffv);
        this.ffv.notifyDataSetChanged();
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        overridePendingTransition(0, 0);
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    public void closeAnimation() {
        overridePendingTransition(0, 0);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        jq(configuration.orientation == 2);
    }

    private void jq(boolean z) {
        if (z) {
            h.U(this.bMW);
            this.bMW.setScaleX(0.85f);
            this.bMW.setScaleY(0.85f);
            return;
        }
        h.V(this.bMW);
        this.bMW.setScaleX(1.0f);
        this.bMW.setScaleY(1.0f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.ffx != null) {
            this.ffx.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.ffy);
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a extends BaseAdapter {
        private ArrayList<d.a> ffB;
        private Context mContext;

        public a(Context context, ArrayList<d.a> arrayList) {
            this.mContext = context;
            this.ffB = arrayList;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.ffB != null) {
                return this.ffB.size();
            }
            return 0;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: pO */
        public d.a getItem(int i) {
            if (this.ffB != null) {
                return this.ffB.get(i);
            }
            return null;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            if (view == null) {
                b bVar2 = new b();
                view = LayoutInflater.from(this.mContext).inflate(a.h.ala_loot_user_item, viewGroup, false);
                bVar2.aSe = (HeadImageView) view.findViewById(a.g.rp_user_list_icon);
                bVar2.aSe.setIsRound(true);
                bVar2.aSe.setDefaultResource(a.f.sdk_icon_default_avatar100_bg);
                bVar2.aSe.setAutoChangeStyle(true);
                bVar2.aSe.setScaleType(ImageView.ScaleType.CENTER_CROP);
                bVar2.ffC = (TextView) view.findViewById(a.g.rp_user_list_name);
                bVar2.ffD = (TextView) view.findViewById(a.g.rp_user_list_amount);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            d.a item = getItem(i);
            if (item != null) {
                if (!StringUtils.isNullObject(item.portrait)) {
                    com.baidu.live.utils.k.a(bVar.aSe, item.portrait, true, false);
                }
                bVar.ffC.setText(item.userName);
                bVar.ffD.setText(String.format(this.mContext.getResources().getString(a.i.snatch_red_packet_t_dou_suffix), Long.valueOf(item.fDQ)));
            }
            return view;
        }
    }

    /* loaded from: classes3.dex */
    private static class b {
        public HeadImageView aSe;
        public TextView ffC;
        public TextView ffD;

        private b() {
        }
    }
}
