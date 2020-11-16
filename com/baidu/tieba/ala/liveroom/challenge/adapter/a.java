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
import com.baidu.live.utils.l;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a extends BaseAdapter {
    private long bmk;
    private long fXY;
    private ArrayList<com.baidu.tieba.ala.liveroom.challenge.a.a> fZl = new ArrayList<>();
    private boolean mIsHost;
    private TbPageContext mTbPageContext;
    private int mType;

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    public void setData(List<com.baidu.tieba.ala.liveroom.challenge.a.a> list) {
        if (this.fZl == null) {
            this.fZl = new ArrayList<>();
        } else {
            this.fZl.clear();
        }
        this.fZl.addAll(list);
        notifyDataSetChanged();
    }

    public void a(int i, long j, long j2, boolean z) {
        this.bmk = j;
        this.mIsHost = z;
        this.mType = i;
        this.fXY = j2;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fZl != null) {
            return this.fZl.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.fZl != null) {
            return this.fZl.get(i);
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
        C0668a c0668a;
        if (view == null) {
            view = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.g.ala_jinzhu_list_item_layout, viewGroup, false);
            C0668a c0668a2 = new C0668a(view);
            view.setTag(c0668a2);
            c0668a = c0668a2;
        } else {
            c0668a = (C0668a) view.getTag();
        }
        com.baidu.tieba.ala.liveroom.challenge.a.a aVar = (com.baidu.tieba.ala.liveroom.challenge.a.a) getItem(i);
        if (aVar != null) {
            c0668a.a(i, aVar);
        }
        return view;
    }

    /* renamed from: com.baidu.tieba.ala.liveroom.challenge.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0668a {
        private HeadImageView buT;
        private ImageView gZC;
        private TextView gZD;
        private TextView gZE;
        private TextView gZF;

        public C0668a(View view) {
            this.gZC = (ImageView) view.findViewById(a.f.id_jinzhu_item_rank_no_iv);
            this.gZD = (TextView) view.findViewById(a.f.id_jinzhu_item_rank_no_tv);
            this.gZE = (TextView) view.findViewById(a.f.id_jinzhu_item_pk_score);
            this.gZF = (TextView) view.findViewById(a.f.id_jinzhu_item_name);
            this.buT = (HeadImageView) view.findViewById(a.f.id_jinzhu_item_head_iv);
            this.buT.setIsRound(true);
            this.buT.setAutoChangeStyle(false);
            this.buT.setDefaultResource(a.e.sdk_pic_mycenter_avatar_def);
            this.buT.setDefaultErrorResource(a.e.sdk_pic_mycenter_avatar_def);
        }

        public void a(int i, final com.baidu.tieba.ala.liveroom.challenge.a.a aVar) {
            if (aVar != null) {
                if (i == 0) {
                    this.gZC.setVisibility(0);
                    this.gZD.setVisibility(4);
                    this.gZC.setImageResource(a.e.icon_jinzhu_item_rank1);
                } else if (i == 1) {
                    this.gZC.setVisibility(0);
                    this.gZD.setVisibility(4);
                    this.gZC.setImageResource(a.e.icon_jinzhu_item_rank2);
                } else if (i == 2) {
                    this.gZC.setVisibility(0);
                    this.gZD.setVisibility(4);
                    this.gZC.setImageResource(a.e.icon_jinzhu_item_rank3);
                } else {
                    this.gZC.setVisibility(4);
                    this.gZD.setVisibility(0);
                    this.gZD.setText(String.valueOf(i + 1));
                }
                if (aVar.aMK != null) {
                    l.a(this.buT, aVar.aMK.portrait, true, false);
                    this.gZF.setText(aVar.aMK.nickName);
                }
                this.gZE.setText(aVar.score);
                this.buT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.adapter.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        AlaLiveUserInfoData alaLiveUserInfoData = aVar.aMK;
                        if (alaLiveUserInfoData != null) {
                            a.this.mTbPageContext.getPageActivity().finish();
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(a.this.mTbPageContext.getPageActivity(), alaLiveUserInfoData.userId + "", alaLiveUserInfoData.userName, alaLiveUserInfoData.portrait, 0, 0, null, null, 0L, 0L, 0L, 0, null, String.valueOf(a.this.bmk), a.this.mIsHost, String.valueOf(a.this.fXY), null, alaLiveUserInfoData.userName, "")));
                        }
                    }
                });
            }
        }
    }
}
