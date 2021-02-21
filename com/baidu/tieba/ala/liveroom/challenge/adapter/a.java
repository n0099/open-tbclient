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
    private long goZ;
    private ArrayList<com.baidu.tieba.ala.liveroom.challenge.a.a> gqm = new ArrayList<>();
    private boolean mIsHost;
    private TbPageContext mTbPageContext;
    private int mType;

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    public void setData(List<com.baidu.tieba.ala.liveroom.challenge.a.a> list) {
        if (this.gqm == null) {
            this.gqm = new ArrayList<>();
        } else {
            this.gqm.clear();
        }
        this.gqm.addAll(list);
        notifyDataSetChanged();
    }

    public void b(int i, long j, long j2, boolean z) {
        this.buN = j;
        this.mIsHost = z;
        this.mType = i;
        this.goZ = j2;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gqm != null) {
            return this.gqm.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.gqm != null) {
            return this.gqm.get(i);
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
        C0659a c0659a;
        if (view == null) {
            view = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.g.ala_jinzhu_list_item_layout, viewGroup, false);
            C0659a c0659a2 = new C0659a(view);
            view.setTag(c0659a2);
            c0659a = c0659a2;
        } else {
            c0659a = (C0659a) view.getTag();
        }
        com.baidu.tieba.ala.liveroom.challenge.a.a aVar = (com.baidu.tieba.ala.liveroom.challenge.a.a) getItem(i);
        if (aVar != null) {
            c0659a.a(i, aVar);
        }
        return view;
    }

    /* renamed from: com.baidu.tieba.ala.liveroom.challenge.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public class C0659a {
        private HeadImageView bDK;
        private ImageView hva;
        private TextView hvb;
        private TextView hvc;
        private TextView hvd;

        public C0659a(View view) {
            this.hva = (ImageView) view.findViewById(a.f.id_jinzhu_item_rank_no_iv);
            this.hvb = (TextView) view.findViewById(a.f.id_jinzhu_item_rank_no_tv);
            this.hvc = (TextView) view.findViewById(a.f.id_jinzhu_item_pk_score);
            this.hvd = (TextView) view.findViewById(a.f.id_jinzhu_item_name);
            this.bDK = (HeadImageView) view.findViewById(a.f.id_jinzhu_item_head_iv);
            this.bDK.setIsRound(true);
            this.bDK.setAutoChangeStyle(false);
            this.bDK.setDefaultResource(a.e.sdk_icon_default_avatar100);
            this.bDK.setDefaultErrorResource(a.e.sdk_icon_default_avatar100);
        }

        public void a(int i, final com.baidu.tieba.ala.liveroom.challenge.a.a aVar) {
            if (aVar != null) {
                if (i == 0) {
                    this.hva.setVisibility(0);
                    this.hvb.setVisibility(4);
                    this.hva.setImageResource(a.e.icon_jinzhu_item_rank1);
                } else if (i == 1) {
                    this.hva.setVisibility(0);
                    this.hvb.setVisibility(4);
                    this.hva.setImageResource(a.e.icon_jinzhu_item_rank2);
                } else if (i == 2) {
                    this.hva.setVisibility(0);
                    this.hvb.setVisibility(4);
                    this.hva.setImageResource(a.e.icon_jinzhu_item_rank3);
                } else {
                    this.hva.setVisibility(4);
                    this.hvb.setVisibility(0);
                    this.hvb.setText(String.valueOf(i + 1));
                }
                if (aVar.aOI != null) {
                    m.a(this.bDK, aVar.aOI.portrait, true, false);
                    this.hvd.setText(aVar.aOI.nickName);
                }
                this.hvc.setText(aVar.score);
                this.bDK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.adapter.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        AlaLiveUserInfoData alaLiveUserInfoData = aVar.aOI;
                        if (alaLiveUserInfoData != null) {
                            a.this.mTbPageContext.getPageActivity().finish();
                            AlaPersonCardActivityConfig alaPersonCardActivityConfig = new AlaPersonCardActivityConfig(a.this.mTbPageContext.getPageActivity(), alaLiveUserInfoData.userId + "", alaLiveUserInfoData.userName, alaLiveUserInfoData.portrait, 0, 0, null, null, 0L, 0L, 0L, 0, null, String.valueOf(a.this.buN), a.this.mIsHost, String.valueOf(a.this.goZ), null, alaLiveUserInfoData.userName);
                            alaPersonCardActivityConfig.setExtInfo(alaLiveUserInfoData.extInfoJson);
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaPersonCardActivityConfig));
                        }
                    }
                });
            }
        }
    }
}
