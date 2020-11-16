package com.baidu.tieba.ala.headline.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.widget.listview.BdListView;
import com.baidu.live.ak.c;
import com.baidu.live.data.w;
import com.baidu.live.gift.aa;
import com.baidu.live.gift.g;
import com.baidu.live.gift.h;
import com.baidu.live.message.AlaSdkGetGiftListHttpResponseMessage;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.BuyTBeanActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaGetHeadlineView extends RelativeLayout {
    private w bph;
    private ArrayList<g> eHj;
    public RelativeLayout gKD;
    private TextView gKO;
    private b gKP;
    private TextView gKQ;
    private HeadImageView gKR;
    private TextView gKS;
    private TextView gKT;
    public Button gKU;
    public long gKV;
    private Activity mActivity;
    Context mContext;
    private BdListView mListView;
    private View mView;
    String otherParams;

    public AlaGetHeadlineView(Context context) {
        super(context);
        this.eHj = new ArrayList<>();
        this.otherParams = "";
    }

    public AlaGetHeadlineView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AlaGetHeadlineView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eHj = new ArrayList<>();
        this.otherParams = "";
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.mView = LayoutInflater.from(getContext()).inflate(a.g.sdk_get_headline_dialog, (ViewGroup) this, true);
        this.gKQ = (TextView) this.mView.findViewById(a.f.get_view_now_score);
        this.gKD = (RelativeLayout) this.mView.findViewById(a.f.get_view_root_container);
        this.gKU = (Button) this.mView.findViewById(a.f.get_view_horizontal_close_button);
        this.gKU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.headline.view.AlaGetHeadlineView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaGetHeadlineView.this.mActivity.finish();
            }
        });
        this.gKR = (HeadImageView) this.mView.findViewById(a.f.get_view_live_head);
        this.gKR.setDefaultBgResource(a.e.sdk_default_avatar);
        this.gKR.setIsRound(true);
        this.gKR.setAutoChangeStyle(false);
        this.gKS = (TextView) this.mView.findViewById(a.f.get_view_live_name);
        this.gKP = new b(getContext());
        this.gKO = (TextView) this.mView.findViewById(a.f.get_headline_button);
        this.gKO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.headline.view.AlaGetHeadlineView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TbadkCoreApplication.isLogin()) {
                    if (!AlaGetHeadlineView.this.bph.aHI.aGA) {
                        BdUtilHelper.showToast(AlaGetHeadlineView.this.mActivity, AlaGetHeadlineView.this.getResources().getString(a.h.sdk_get_headline_not_open_tip));
                        AlaGetHeadlineView.this.mActivity.finish();
                        return;
                    } else if (!AlaGetHeadlineView.this.eHj.isEmpty()) {
                        long j = TbadkCoreApplication.getInst().currentAccountTdouNum;
                        g gVar = (g) AlaGetHeadlineView.this.eHj.get(AlaGetHeadlineView.this.gKP.bTO());
                        if (j >= Long.parseLong(gVar.getPrice()) * Long.parseLong(gVar.Fn())) {
                            AlaGetHeadlineView.this.g((g) AlaGetHeadlineView.this.eHj.get(AlaGetHeadlineView.this.gKP.bTO()));
                            return;
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(AlaGetHeadlineView.this.mContext, 0L, AlaGetHeadlineView.this.otherParams, true, "", true)));
                        return;
                    } else {
                        return;
                    }
                }
                ViewHelper.skipToLoginActivity(AlaGetHeadlineView.this.mContext);
            }
        });
        this.mListView = (BdListView) this.mView.findViewById(a.f.get_view_gift_list);
        this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.ala.headline.view.AlaGetHeadlineView.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AlaGetHeadlineView.this.gKP.vm(i);
                AlaGetHeadlineView.this.gKP.notifyDataSetChanged();
            }
        });
        this.gKT = (TextView) this.mView.findViewById(a.f.get_view_get_headline_support);
        this.gKT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.headline.view.AlaGetHeadlineView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c cVar = new c();
                cVar.url = AlaGetHeadlineView.this.bph.aHI.aGK;
                cVar.bMs = 0.8f;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913244, cVar));
            }
        });
        this.mListView.setAdapter((ListAdapter) this.gKP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(g gVar) {
        aa.b(gVar, Long.parseLong(gVar.Fn()), this.bph.aHk.userId + "", this.bph.aHk.userName, this.bph.mLiveInfo.live_id + "", this.bph.mLiveInfo.room_id + "", this.bph.mLiveInfo.appId + "", this.bph.mLiveInfo.feed_id + "", this.otherParams, 0L);
        this.mActivity.finish();
    }

    public void setData(w wVar, String str) {
        this.otherParams = str;
        this.bph = wVar;
        this.eHj.clear();
        setData2View(wVar);
    }

    private void setData2View(w wVar) {
        if (this.gKV > 0 && wVar.aHI.aGB > 0 && wVar.aHI.aGD > wVar.aHI.aGB) {
            this.gKQ.setText(com.baidu.tieba.ala.headline.a.eI(wVar.aHI.aGD));
            z(wVar.aHI.aGD);
        } else {
            this.gKQ.setText(com.baidu.tieba.ala.headline.a.eI(wVar.aHI.aGB));
            z(wVar.aHI.aGB);
            this.gKP.bTP();
        }
        this.gKR.startLoad(wVar.aHk.portrait, 12, false, false);
        this.gKS.setText(wVar.aHk.nickName);
    }

    private void z(double d) {
        String GF = aa.GF();
        if (GF != null && GF.length() != 0) {
            AlaSdkGetGiftListHttpResponseMessage alaSdkGetGiftListHttpResponseMessage = new AlaSdkGetGiftListHttpResponseMessage();
            try {
                alaSdkGetGiftListHttpResponseMessage.a(new JSONObject(GF), true);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            Iterator<h> it = alaSdkGetGiftListHttpResponseMessage.IG().iterator();
            while (it.hasNext()) {
                for (g gVar : it.next().FL()) {
                    if (gVar.aSW) {
                        int ceil = (int) Math.ceil(d / Double.parseDouble(gVar.getPrice()));
                        if (ceil == ((int) Math.floor(d / Double.parseDouble(gVar.getPrice())))) {
                            ceil++;
                        }
                        gVar.gA(ceil + "");
                        this.eHj.add(gVar);
                    }
                }
            }
            ad(this.eHj);
            this.gKP.a(this.eHj, d);
        }
    }

    private void ad(ArrayList<g> arrayList) {
        Collections.sort(arrayList, new Comparator<g>() { // from class: com.baidu.tieba.ala.headline.view.AlaGetHeadlineView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(g gVar, g gVar2) {
                long parseLong = (Long.parseLong(gVar.Fn()) * Long.parseLong(gVar.getPrice())) - (Long.parseLong(gVar2.Fn()) * Long.parseLong(gVar2.getPrice()));
                if (parseLong > 0) {
                    return 1;
                }
                if (parseLong < 0) {
                    return -1;
                }
                return 0;
            }
        });
    }

    public void setActivity(Activity activity) {
        this.mActivity = activity;
    }
}
