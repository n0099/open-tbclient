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
import com.baidu.live.data.y;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.BaseFragmentActivity;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.utils.h;
import com.baidu.live.utils.k;
import com.baidu.tieba.ala.data.e;
import com.baidu.tieba.ala.f.l;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class AlaRedPacketSnatchResultActivity extends BaseFragmentActivity {
    private HeadImageView aZM;
    private FrameLayout bTn;
    private String beu;
    private TextView dTU;
    private View fup;
    private LinearLayout fuq;
    private TextView fvU;
    private TextView fvV;
    private TextView fvW;
    private BdListView fvX;
    private a fvY;
    private com.baidu.tieba.ala.data.e fvZ;
    private com.baidu.tieba.ala.f.f fwa;
    private CustomMessageListener fwb = new CustomMessageListener(2913129) { // from class: com.baidu.tieba.ala.AlaRedPacketSnatchResultActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaRedPacketSnatchResultActivity.this.finish();
        }
    };
    private l fwc = new l() { // from class: com.baidu.tieba.ala.AlaRedPacketSnatchResultActivity.2
        @Override // com.baidu.tieba.ala.f.l
        public void b(com.baidu.tieba.ala.data.e eVar) {
            AlaRedPacketSnatchResultActivity.this.a(eVar);
        }

        @Override // com.baidu.tieba.ala.f.l
        public void ay(int i, String str) {
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
            this.fwa = new com.baidu.tieba.ala.f.f(getPageContext(), this.fwc);
            this.fwa.aj(this.mRedPacketId, this.mLiveId, this.beu);
            MessageManager.getInstance().registerListener(this.fwb);
            ku(UtilHelper.getRealScreenOrientation(this) == 2);
        }
    }

    private void parserIntent() {
        this.mRedPacketId = getIntent().getStringExtra("red_packet_id");
        this.mLiveId = getIntent().getStringExtra("live_id");
        this.beu = getIntent().getStringExtra("anchor_id");
    }

    private void initView() {
        this.fup = findViewById(a.g.rp_result_root_bg);
        this.fup.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaRedPacketSnatchResultActivity.3
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
        this.bTn = (FrameLayout) findViewById(a.g.rp_result_root_container);
        this.aZM = (HeadImageView) findViewById(a.g.rp_result_user_icon);
        this.aZM.setBorderWidth(BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.e.sdk_ds6));
        this.aZM.setBorderColor(getPageContext().getResources().getColor(a.d.ala_red_packet_main_color));
        this.aZM.setIsRound(true);
        this.aZM.setDefaultResource(a.f.sdk_icon_default_avatar100_bg);
        this.aZM.setAutoChangeStyle(true);
        this.aZM.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fvU = (TextView) findViewById(a.g.p_result_top10_desc);
        this.dTU = (TextView) findViewById(a.g.p_result_user_name);
        this.fvV = (TextView) findViewById(a.g.p_result_loot_amount);
        this.fuq = (LinearLayout) findViewById(a.g.rp_result_content);
        this.fvW = (TextView) findViewById(a.g.p_result_send_gift);
        this.fvX = (BdListView) findViewById(a.g.p_result_listview);
        this.fvW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaRedPacketSnatchResultActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaRedPacketSnatchResultActivity.this.finish();
                AlaRedPacketSnatchResultActivity.this.bDM();
            }
        });
        this.fuq.setVisibility(8);
        this.fvW.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDM() {
        y yVar = new y();
        yVar.aEB = -1;
        yVar.aEC = -1;
        yVar.aEE = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, yVar));
    }

    public void a(com.baidu.tieba.ala.data.e eVar) {
        String str;
        this.fvZ = eVar;
        this.fuq.setVisibility(0);
        this.fvW.setVisibility(0);
        if (!StringUtils.isNullObject(eVar.portrait)) {
            k.a(this.aZM, eVar.portrait, true, false);
        }
        this.dTU.setText(eVar.userName);
        if (eVar.fUE) {
            String format = String.format(getPageContext().getResources().getString(a.i.snatch_red_packet_amount_desc), Long.valueOf(eVar.fUm));
            this.fvW.setVisibility(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fuq.getLayoutParams();
            layoutParams.bottomMargin = getPageContext().getResources().getDimensionPixelSize(a.e.sdk_ds184);
            this.fuq.setLayoutParams(layoutParams);
            str = format;
        } else {
            String string = getPageContext().getResources().getString(a.i.snatch_red_packet_failed_1);
            this.fvW.setVisibility(8);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.fuq.getLayoutParams();
            layoutParams2.bottomMargin = getPageContext().getResources().getDimensionPixelSize(a.e.sdk_ds50);
            this.fuq.setLayoutParams(layoutParams2);
            str = string;
        }
        this.fvV.setText(str);
        W(eVar.fUF);
    }

    private void W(ArrayList<e.a> arrayList) {
        this.fvY = new a(getPageContext().getPageActivity(), arrayList);
        this.fvX.setAdapter((ListAdapter) this.fvY);
        this.fvY.notifyDataSetChanged();
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
        ku(configuration.orientation == 2);
    }

    private void ku(boolean z) {
        if (z) {
            h.Y(this.bTn);
            this.bTn.setScaleX(0.85f);
            this.bTn.setScaleY(0.85f);
            return;
        }
        h.Z(this.bTn);
        this.bTn.setScaleX(1.0f);
        this.bTn.setScaleY(1.0f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.fwa != null) {
            this.fwa.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.fwb);
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static class a extends BaseAdapter {
        private ArrayList<e.a> fwe;
        private Context mContext;

        public a(Context context, ArrayList<e.a> arrayList) {
            this.mContext = context;
            this.fwe = arrayList;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.fwe != null) {
                return this.fwe.size();
            }
            return 0;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: sn */
        public e.a getItem(int i) {
            if (this.fwe != null) {
                return this.fwe.get(i);
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
                bVar2.aYN = (HeadImageView) view.findViewById(a.g.rp_user_list_icon);
                bVar2.aYN.setIsRound(true);
                bVar2.aYN.setDefaultResource(a.f.sdk_icon_default_avatar100_bg);
                bVar2.aYN.setAutoChangeStyle(true);
                bVar2.aYN.setScaleType(ImageView.ScaleType.CENTER_CROP);
                bVar2.fwf = (TextView) view.findViewById(a.g.rp_user_list_name);
                bVar2.fwg = (TextView) view.findViewById(a.g.rp_user_list_amount);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            e.a item = getItem(i);
            if (item != null) {
                if (!StringUtils.isNullObject(item.portrait)) {
                    k.a(bVar.aYN, item.portrait, true, false);
                }
                bVar.fwf.setText(item.userName);
                bVar.fwg.setText(String.format(this.mContext.getResources().getString(a.i.snatch_red_packet_t_dou_suffix), Long.valueOf(item.fUG)));
            }
            return view;
        }
    }

    /* loaded from: classes7.dex */
    private static class b {
        public HeadImageView aYN;
        public TextView fwf;
        public TextView fwg;

        private b() {
        }
    }
}
