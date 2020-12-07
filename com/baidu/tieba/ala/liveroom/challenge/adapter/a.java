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
    private long brr;
    private long ggj;
    private ArrayList<com.baidu.tieba.ala.liveroom.challenge.a.a> ghw = new ArrayList<>();
    private boolean mIsHost;
    private TbPageContext mTbPageContext;
    private int mType;

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    public void setData(List<com.baidu.tieba.ala.liveroom.challenge.a.a> list) {
        if (this.ghw == null) {
            this.ghw = new ArrayList<>();
        } else {
            this.ghw.clear();
        }
        this.ghw.addAll(list);
        notifyDataSetChanged();
    }

    public void a(int i, long j, long j2, boolean z) {
        this.brr = j;
        this.mIsHost = z;
        this.mType = i;
        this.ggj = j2;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.ghw != null) {
            return this.ghw.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.ghw != null) {
            return this.ghw.get(i);
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
        C0681a c0681a;
        if (view == null) {
            view = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.g.ala_jinzhu_list_item_layout, viewGroup, false);
            C0681a c0681a2 = new C0681a(view);
            view.setTag(c0681a2);
            c0681a = c0681a2;
        } else {
            c0681a = (C0681a) view.getTag();
        }
        com.baidu.tieba.ala.liveroom.challenge.a.a aVar = (com.baidu.tieba.ala.liveroom.challenge.a.a) getItem(i);
        if (aVar != null) {
            c0681a.a(i, aVar);
        }
        return view;
    }

    /* renamed from: com.baidu.tieba.ala.liveroom.challenge.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0681a {
        private HeadImageView bAd;
        private ImageView hjl;
        private TextView hjm;
        private TextView hjn;
        private TextView hjo;

        public C0681a(View view) {
            this.hjl = (ImageView) view.findViewById(a.f.id_jinzhu_item_rank_no_iv);
            this.hjm = (TextView) view.findViewById(a.f.id_jinzhu_item_rank_no_tv);
            this.hjn = (TextView) view.findViewById(a.f.id_jinzhu_item_pk_score);
            this.hjo = (TextView) view.findViewById(a.f.id_jinzhu_item_name);
            this.bAd = (HeadImageView) view.findViewById(a.f.id_jinzhu_item_head_iv);
            this.bAd.setIsRound(true);
            this.bAd.setAutoChangeStyle(false);
            this.bAd.setDefaultResource(a.e.sdk_pic_mycenter_avatar_def);
            this.bAd.setDefaultErrorResource(a.e.sdk_pic_mycenter_avatar_def);
        }

        public void a(int i, final com.baidu.tieba.ala.liveroom.challenge.a.a aVar) {
            if (aVar != null) {
                if (i == 0) {
                    this.hjl.setVisibility(0);
                    this.hjm.setVisibility(4);
                    this.hjl.setImageResource(a.e.icon_jinzhu_item_rank1);
                } else if (i == 1) {
                    this.hjl.setVisibility(0);
                    this.hjm.setVisibility(4);
                    this.hjl.setImageResource(a.e.icon_jinzhu_item_rank2);
                } else if (i == 2) {
                    this.hjl.setVisibility(0);
                    this.hjm.setVisibility(4);
                    this.hjl.setImageResource(a.e.icon_jinzhu_item_rank3);
                } else {
                    this.hjl.setVisibility(4);
                    this.hjm.setVisibility(0);
                    this.hjm.setText(String.valueOf(i + 1));
                }
                if (aVar.aPJ != null) {
                    l.a(this.bAd, aVar.aPJ.portrait, true, false);
                    this.hjo.setText(aVar.aPJ.nickName);
                }
                this.hjn.setText(aVar.score);
                this.bAd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.adapter.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        AlaLiveUserInfoData alaLiveUserInfoData = aVar.aPJ;
                        if (alaLiveUserInfoData != null) {
                            a.this.mTbPageContext.getPageActivity().finish();
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(a.this.mTbPageContext.getPageActivity(), alaLiveUserInfoData.userId + "", alaLiveUserInfoData.userName, alaLiveUserInfoData.portrait, 0, 0, null, null, 0L, 0L, 0L, 0, null, String.valueOf(a.this.brr), a.this.mIsHost, String.valueOf(a.this.ggj), null, alaLiveUserInfoData.userName, "")));
                        }
                    }
                });
            }
        }
    }
}
