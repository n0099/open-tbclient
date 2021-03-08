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
import com.baidu.live.an.c;
import com.baidu.live.data.ab;
import com.baidu.live.gift.ac;
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
/* loaded from: classes10.dex */
public class AlaGetHeadlineView extends RelativeLayout {
    private ab bzn;
    private ArrayList<g> eXu;
    public RelativeLayout hfF;
    private TextView hfQ;
    private b hfR;
    private TextView hfS;
    private HeadImageView hfT;
    private TextView hfU;
    private TextView hfV;
    public Button hfW;
    public long hfX;
    private Activity mActivity;
    Context mContext;
    private BdListView mListView;
    private View mView;
    String otherParams;

    public AlaGetHeadlineView(Context context) {
        super(context);
        this.eXu = new ArrayList<>();
        this.otherParams = "";
    }

    public AlaGetHeadlineView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AlaGetHeadlineView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eXu = new ArrayList<>();
        this.otherParams = "";
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.mView = LayoutInflater.from(getContext()).inflate(a.g.sdk_get_headline_dialog, (ViewGroup) this, true);
        this.hfS = (TextView) this.mView.findViewById(a.f.get_view_now_score);
        this.hfF = (RelativeLayout) this.mView.findViewById(a.f.get_view_root_container);
        this.hfW = (Button) this.mView.findViewById(a.f.get_view_horizontal_close_button);
        this.hfW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.headline.view.AlaGetHeadlineView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaGetHeadlineView.this.mActivity.finish();
            }
        });
        this.hfT = (HeadImageView) this.mView.findViewById(a.f.get_view_live_head);
        this.hfT.setDefaultBgResource(a.e.sdk_default_avatar);
        this.hfT.setIsRound(true);
        this.hfT.setAutoChangeStyle(false);
        this.hfU = (TextView) this.mView.findViewById(a.f.get_view_live_name);
        this.hfR = new b(getContext());
        this.hfQ = (TextView) this.mView.findViewById(a.f.get_headline_button);
        this.hfQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.headline.view.AlaGetHeadlineView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TbadkCoreApplication.isLogin()) {
                    if (!AlaGetHeadlineView.this.bzn.aKb.aIR) {
                        BdUtilHelper.showToast(AlaGetHeadlineView.this.mActivity, AlaGetHeadlineView.this.getResources().getString(a.h.sdk_get_headline_not_open_tip));
                        AlaGetHeadlineView.this.mActivity.finish();
                        return;
                    } else if (!AlaGetHeadlineView.this.eXu.isEmpty()) {
                        long j = TbadkCoreApplication.getInst().currentAccountTdouNum;
                        g gVar = (g) AlaGetHeadlineView.this.eXu.get(AlaGetHeadlineView.this.hfR.bXd());
                        if (j >= Long.parseLong(gVar.getPrice()) * Long.parseLong(gVar.DZ())) {
                            AlaGetHeadlineView.this.i((g) AlaGetHeadlineView.this.eXu.get(AlaGetHeadlineView.this.hfR.bXd()));
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
                AlaGetHeadlineView.this.hfR.uG(i);
                AlaGetHeadlineView.this.hfR.notifyDataSetChanged();
            }
        });
        this.hfV = (TextView) this.mView.findViewById(a.f.get_view_get_headline_support);
        this.hfV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.headline.view.AlaGetHeadlineView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c cVar = new c();
                cVar.url = AlaGetHeadlineView.this.bzn.aKb.aJc;
                cVar.bXS = 0.8f;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913244, cVar));
            }
        });
        this.mListView.setAdapter((ListAdapter) this.hfR);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(g gVar) {
        ac.a(gVar, Long.parseLong(gVar.DZ()), this.bzn.aJD.userId + "", this.bzn.aJD.userName, this.bzn.mLiveInfo.live_id + "", this.bzn.mLiveInfo.room_id + "", this.bzn.mLiveInfo.appId + "", this.bzn.mLiveInfo.feed_id + "", this.otherParams, 0L);
        this.mActivity.finish();
    }

    public void setData(ab abVar, String str) {
        this.otherParams = str;
        this.bzn = abVar;
        this.eXu.clear();
        setData2View(abVar);
    }

    private void setData2View(ab abVar) {
        if (this.hfX > 0 && abVar.aKb.aIS > 0 && abVar.aKb.aIU > abVar.aKb.aIS) {
            this.hfS.setText(com.baidu.tieba.ala.headline.a.fs(abVar.aKb.aIU));
            t(abVar.aKb.aIU);
        } else {
            this.hfS.setText(com.baidu.tieba.ala.headline.a.fs(abVar.aKb.aIS));
            t(abVar.aKb.aIS);
            this.hfR.bXe();
        }
        this.hfT.startLoad(abVar.aJD.portrait, 12, false, false);
        this.hfU.setText(abVar.aJD.nickName);
    }

    private void t(double d) {
        String Fv = ac.Fv();
        if (Fv != null && Fv.length() != 0) {
            AlaSdkGetGiftListHttpResponseMessage alaSdkGetGiftListHttpResponseMessage = new AlaSdkGetGiftListHttpResponseMessage();
            try {
                alaSdkGetGiftListHttpResponseMessage.a(new JSONObject(Fv), true);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            Iterator<h> it = alaSdkGetGiftListHttpResponseMessage.HF().iterator();
            while (it.hasNext()) {
                for (g gVar : it.next().Ez()) {
                    if (gVar.aXw) {
                        int ceil = (int) Math.ceil(d / Double.parseDouble(gVar.getPrice()));
                        if (ceil == ((int) Math.floor(d / Double.parseDouble(gVar.getPrice())))) {
                            ceil++;
                        }
                        gVar.fV(ceil + "");
                        this.eXu.add(gVar);
                    }
                }
            }
            Y(this.eXu);
            this.hfR.a(this.eXu, d);
        }
    }

    private void Y(ArrayList<g> arrayList) {
        Collections.sort(arrayList, new Comparator<g>() { // from class: com.baidu.tieba.ala.headline.view.AlaGetHeadlineView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(g gVar, g gVar2) {
                long parseLong = (Long.parseLong(gVar.DZ()) * Long.parseLong(gVar.getPrice())) - (Long.parseLong(gVar2.DZ()) * Long.parseLong(gVar2.getPrice()));
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
