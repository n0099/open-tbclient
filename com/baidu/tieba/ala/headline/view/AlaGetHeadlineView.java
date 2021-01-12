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
import com.baidu.live.ap.c;
import com.baidu.live.data.x;
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
    private x buq;
    private ArrayList<g> eTF;
    public RelativeLayout haY;
    private TextView hbk;
    private b hbl;
    private TextView hbm;
    private HeadImageView hbn;
    private TextView hbo;
    private TextView hbp;
    public Button hbq;
    public long hbr;
    private Activity mActivity;
    Context mContext;
    private BdListView mListView;
    private View mView;
    String otherParams;

    public AlaGetHeadlineView(Context context) {
        super(context);
        this.eTF = new ArrayList<>();
        this.otherParams = "";
    }

    public AlaGetHeadlineView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AlaGetHeadlineView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eTF = new ArrayList<>();
        this.otherParams = "";
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.mView = LayoutInflater.from(getContext()).inflate(a.g.sdk_get_headline_dialog, (ViewGroup) this, true);
        this.hbm = (TextView) this.mView.findViewById(a.f.get_view_now_score);
        this.haY = (RelativeLayout) this.mView.findViewById(a.f.get_view_root_container);
        this.hbq = (Button) this.mView.findViewById(a.f.get_view_horizontal_close_button);
        this.hbq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.headline.view.AlaGetHeadlineView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaGetHeadlineView.this.mActivity.finish();
            }
        });
        this.hbn = (HeadImageView) this.mView.findViewById(a.f.get_view_live_head);
        this.hbn.setDefaultBgResource(a.e.sdk_default_avatar);
        this.hbn.setIsRound(true);
        this.hbn.setAutoChangeStyle(false);
        this.hbo = (TextView) this.mView.findViewById(a.f.get_view_live_name);
        this.hbl = new b(getContext());
        this.hbk = (TextView) this.mView.findViewById(a.f.get_headline_button);
        this.hbk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.headline.view.AlaGetHeadlineView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TbadkCoreApplication.isLogin()) {
                    if (!AlaGetHeadlineView.this.buq.aGf.aEV) {
                        BdUtilHelper.showToast(AlaGetHeadlineView.this.mActivity, AlaGetHeadlineView.this.getResources().getString(a.h.sdk_get_headline_not_open_tip));
                        AlaGetHeadlineView.this.mActivity.finish();
                        return;
                    } else if (!AlaGetHeadlineView.this.eTF.isEmpty()) {
                        long j = TbadkCoreApplication.getInst().currentAccountTdouNum;
                        g gVar = (g) AlaGetHeadlineView.this.eTF.get(AlaGetHeadlineView.this.hbl.bWm());
                        if (j >= Long.parseLong(gVar.getPrice()) * Long.parseLong(gVar.CG())) {
                            AlaGetHeadlineView.this.i((g) AlaGetHeadlineView.this.eTF.get(AlaGetHeadlineView.this.hbl.bWm()));
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
                AlaGetHeadlineView.this.hbl.uy(i);
                AlaGetHeadlineView.this.hbl.notifyDataSetChanged();
            }
        });
        this.hbp = (TextView) this.mView.findViewById(a.f.get_view_get_headline_support);
        this.hbp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.headline.view.AlaGetHeadlineView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c cVar = new c();
                cVar.url = AlaGetHeadlineView.this.buq.aGf.aFg;
                cVar.bSt = 0.8f;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913244, cVar));
            }
        });
        this.mListView.setAdapter((ListAdapter) this.hbl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(g gVar) {
        ac.a(gVar, Long.parseLong(gVar.CG()), this.buq.aFH.userId + "", this.buq.aFH.userName, this.buq.mLiveInfo.live_id + "", this.buq.mLiveInfo.room_id + "", this.buq.mLiveInfo.appId + "", this.buq.mLiveInfo.feed_id + "", this.otherParams, 0L);
        this.mActivity.finish();
    }

    public void setData(x xVar, String str) {
        this.otherParams = str;
        this.buq = xVar;
        this.eTF.clear();
        setData2View(xVar);
    }

    private void setData2View(x xVar) {
        if (this.hbr > 0 && xVar.aGf.aEW > 0 && xVar.aGf.aEY > xVar.aGf.aEW) {
            this.hbm.setText(com.baidu.tieba.ala.headline.a.fm(xVar.aGf.aEY));
            t(xVar.aGf.aEY);
        } else {
            this.hbm.setText(com.baidu.tieba.ala.headline.a.fm(xVar.aGf.aEW));
            t(xVar.aGf.aEW);
            this.hbl.bWn();
        }
        this.hbn.startLoad(xVar.aFH.portrait, 12, false, false);
        this.hbo.setText(xVar.aFH.nickName);
    }

    private void t(double d) {
        String Ec = ac.Ec();
        if (Ec != null && Ec.length() != 0) {
            AlaSdkGetGiftListHttpResponseMessage alaSdkGetGiftListHttpResponseMessage = new AlaSdkGetGiftListHttpResponseMessage();
            try {
                alaSdkGetGiftListHttpResponseMessage.c(new JSONObject(Ec), true);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            Iterator<h> it = alaSdkGetGiftListHttpResponseMessage.Gm().iterator();
            while (it.hasNext()) {
                for (g gVar : it.next().Dg()) {
                    if (gVar.aSR) {
                        int ceil = (int) Math.ceil(d / Double.parseDouble(gVar.getPrice()));
                        if (ceil == ((int) Math.floor(d / Double.parseDouble(gVar.getPrice())))) {
                            ceil++;
                        }
                        gVar.fu(ceil + "");
                        this.eTF.add(gVar);
                    }
                }
            }
            Z(this.eTF);
            this.hbl.a(this.eTF, d);
        }
    }

    private void Z(ArrayList<g> arrayList) {
        Collections.sort(arrayList, new Comparator<g>() { // from class: com.baidu.tieba.ala.headline.view.AlaGetHeadlineView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(g gVar, g gVar2) {
                long parseLong = (Long.parseLong(gVar.CG()) * Long.parseLong(gVar.getPrice())) - (Long.parseLong(gVar2.CG()) * Long.parseLong(gVar2.getPrice()));
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
