package com.baidu.tieba.ala.liveroom.challenge.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.atomdata.AlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.utils.m;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class a extends BaseAdapter {
    private long buN;
    private long goL;
    private ArrayList<com.baidu.tieba.ala.liveroom.challenge.a.a> gpY = new ArrayList<>();
    private boolean mIsHost;
    private TbPageContext mTbPageContext;
    private int mType;

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    public void setData(List<com.baidu.tieba.ala.liveroom.challenge.a.a> list) {
        if (this.gpY == null) {
            this.gpY = new ArrayList<>();
        } else {
            this.gpY.clear();
        }
        this.gpY.addAll(list);
        notifyDataSetChanged();
    }

    public void b(int i, long j, long j2, boolean z) {
        this.buN = j;
        this.mIsHost = z;
        this.mType = i;
        this.goL = j2;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gpY != null) {
            return this.gpY.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.gpY != null) {
            return this.gpY.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return 0;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0658a c0658a;
        if (view == null) {
            view = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.g.ala_jinzhu_list_item_layout, viewGroup, false);
            C0658a c0658a2 = new C0658a(view);
            view.setTag(c0658a2);
            c0658a = c0658a2;
        } else {
            c0658a = (C0658a) view.getTag();
        }
        com.baidu.tieba.ala.liveroom.challenge.a.a aVar = (com.baidu.tieba.ala.liveroom.challenge.a.a) getItem(i);
        if (aVar != null) {
            c0658a.a(i, aVar);
        }
        return view;
    }

    /* renamed from: com.baidu.tieba.ala.liveroom.challenge.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public class C0658a {
        private HeadImageView bDK;
        private ImageView huM;
        private TextView huN;
        private TextView huO;
        private TextView huP;

        public C0658a(View view) {
            this.huM = (ImageView) view.findViewById(a.f.id_jinzhu_item_rank_no_iv);
            this.huN = (TextView) view.findViewById(a.f.id_jinzhu_item_rank_no_tv);
            this.huO = (TextView) view.findViewById(a.f.id_jinzhu_item_pk_score);
            this.huP = (TextView) view.findViewById(a.f.id_jinzhu_item_name);
            this.bDK = (HeadImageView) view.findViewById(a.f.id_jinzhu_item_head_iv);
            this.bDK.setIsRound(true);
            this.bDK.setAutoChangeStyle(false);
            this.bDK.setDefaultResource(a.e.sdk_icon_default_avatar100);
            this.bDK.setDefaultErrorResource(a.e.sdk_icon_default_avatar100);
        }

        public void a(int i, final com.baidu.tieba.ala.liveroom.challenge.a.a aVar) {
            if (aVar != null) {
                if (i == 0) {
                    this.huM.setVisibility(0);
                    this.huN.setVisibility(4);
                    this.huM.setImageResource(a.e.icon_jinzhu_item_rank1);
                } else if (i == 1) {
                    this.huM.setVisibility(0);
                    this.huN.setVisibility(4);
                    this.huM.setImageResource(a.e.icon_jinzhu_item_rank2);
                } else if (i == 2) {
                    this.huM.setVisibility(0);
                    this.huN.setVisibility(4);
                    this.huM.setImageResource(a.e.icon_jinzhu_item_rank3);
                } else {
                    this.huM.setVisibility(4);
                    this.huN.setVisibility(0);
                    this.huN.setText(String.valueOf(i + 1));
                }
                if (aVar.aOI != null) {
                    m.a(this.bDK, aVar.aOI.portrait, true, false);
                    this.huP.setText(aVar.aOI.nickName);
                }
                this.huO.setText(aVar.score);
                this.bDK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.adapter.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        AlaLiveUserInfoData alaLiveUserInfoData = aVar.aOI;
                        if (alaLiveUserInfoData != null) {
                            a.this.mTbPageContext.getPageActivity().finish();
                            AlaPersonCardActivityConfig alaPersonCardActivityConfig = new AlaPersonCardActivityConfig(a.this.mTbPageContext.getPageActivity(), alaLiveUserInfoData.userId + "", alaLiveUserInfoData.userName, alaLiveUserInfoData.portrait, 0, 0, null, null, 0L, 0L, 0L, 0, null, String.valueOf(a.this.buN), a.this.mIsHost, String.valueOf(a.this.goL), null, alaLiveUserInfoData.userName);
                            alaPersonCardActivityConfig.setExtInfo(alaLiveUserInfoData.extInfoJson);
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaPersonCardActivityConfig));
                        }
                    }
                });
            }
        }
    }
}
