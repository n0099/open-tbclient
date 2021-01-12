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
/* loaded from: classes10.dex */
public class a extends BaseAdapter {
    private long brk;
    private long gmc;
    private ArrayList<com.baidu.tieba.ala.liveroom.challenge.a.a> gnp = new ArrayList<>();
    private boolean mIsHost;
    private TbPageContext mTbPageContext;
    private int mType;

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    public void setData(List<com.baidu.tieba.ala.liveroom.challenge.a.a> list) {
        if (this.gnp == null) {
            this.gnp = new ArrayList<>();
        } else {
            this.gnp.clear();
        }
        this.gnp.addAll(list);
        notifyDataSetChanged();
    }

    public void b(int i, long j, long j2, boolean z) {
        this.brk = j;
        this.mIsHost = z;
        this.mType = i;
        this.gmc = j2;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gnp != null) {
            return this.gnp.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.gnp != null) {
            return this.gnp.get(i);
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
        C0656a c0656a;
        if (view == null) {
            view = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.g.ala_jinzhu_list_item_layout, viewGroup, false);
            C0656a c0656a2 = new C0656a(view);
            view.setTag(c0656a2);
            c0656a = c0656a2;
        } else {
            c0656a = (C0656a) view.getTag();
        }
        com.baidu.tieba.ala.liveroom.challenge.a.a aVar = (com.baidu.tieba.ala.liveroom.challenge.a.a) getItem(i);
        if (aVar != null) {
            c0656a.a(i, aVar);
        }
        return view;
    }

    /* renamed from: com.baidu.tieba.ala.liveroom.challenge.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public class C0656a {
        private HeadImageView bAe;
        private ImageView hqC;
        private TextView hqD;
        private TextView hqE;
        private TextView hqF;

        public C0656a(View view) {
            this.hqC = (ImageView) view.findViewById(a.f.id_jinzhu_item_rank_no_iv);
            this.hqD = (TextView) view.findViewById(a.f.id_jinzhu_item_rank_no_tv);
            this.hqE = (TextView) view.findViewById(a.f.id_jinzhu_item_pk_score);
            this.hqF = (TextView) view.findViewById(a.f.id_jinzhu_item_name);
            this.bAe = (HeadImageView) view.findViewById(a.f.id_jinzhu_item_head_iv);
            this.bAe.setIsRound(true);
            this.bAe.setAutoChangeStyle(false);
            this.bAe.setDefaultResource(a.e.sdk_pic_mycenter_avatar_def);
            this.bAe.setDefaultErrorResource(a.e.sdk_pic_mycenter_avatar_def);
        }

        public void a(int i, final com.baidu.tieba.ala.liveroom.challenge.a.a aVar) {
            if (aVar != null) {
                if (i == 0) {
                    this.hqC.setVisibility(0);
                    this.hqD.setVisibility(4);
                    this.hqC.setImageResource(a.e.icon_jinzhu_item_rank1);
                } else if (i == 1) {
                    this.hqC.setVisibility(0);
                    this.hqD.setVisibility(4);
                    this.hqC.setImageResource(a.e.icon_jinzhu_item_rank2);
                } else if (i == 2) {
                    this.hqC.setVisibility(0);
                    this.hqD.setVisibility(4);
                    this.hqC.setImageResource(a.e.icon_jinzhu_item_rank3);
                } else {
                    this.hqC.setVisibility(4);
                    this.hqD.setVisibility(0);
                    this.hqD.setText(String.valueOf(i + 1));
                }
                if (aVar.aLL != null) {
                    m.a(this.bAe, aVar.aLL.portrait, true, false);
                    this.hqF.setText(aVar.aLL.nickName);
                }
                this.hqE.setText(aVar.score);
                this.bAe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.adapter.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        AlaLiveUserInfoData alaLiveUserInfoData = aVar.aLL;
                        if (alaLiveUserInfoData != null) {
                            a.this.mTbPageContext.getPageActivity().finish();
                            AlaPersonCardActivityConfig alaPersonCardActivityConfig = new AlaPersonCardActivityConfig(a.this.mTbPageContext.getPageActivity(), alaLiveUserInfoData.userId + "", alaLiveUserInfoData.userName, alaLiveUserInfoData.portrait, 0, 0, null, null, 0L, 0L, 0L, 0, null, String.valueOf(a.this.brk), a.this.mIsHost, String.valueOf(a.this.gmc), null, alaLiveUserInfoData.userName);
                            alaPersonCardActivityConfig.setExtInfo(alaLiveUserInfoData.extInfoJson);
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaPersonCardActivityConfig));
                        }
                    }
                });
            }
        }
    }
}
