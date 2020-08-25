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
import com.baidu.live.utils.k;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class a extends BaseAdapter {
    private long bew;
    private long fuJ;
    private ArrayList<com.baidu.tieba.ala.liveroom.challenge.a.a> fwa = new ArrayList<>();
    private boolean mIsHost;
    private TbPageContext mTbPageContext;
    private int mType;

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    public void setData(List<com.baidu.tieba.ala.liveroom.challenge.a.a> list) {
        if (this.fwa == null) {
            this.fwa = new ArrayList<>();
        } else {
            this.fwa.clear();
        }
        this.fwa.addAll(list);
        notifyDataSetChanged();
    }

    public void a(int i, long j, long j2, boolean z) {
        this.bew = j;
        this.mIsHost = z;
        this.mType = i;
        this.fuJ = j2;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fwa != null) {
            return this.fwa.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.fwa != null) {
            return this.fwa.get(i);
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
        C0624a c0624a;
        if (view == null) {
            view = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.h.ala_jinzhu_list_item_layout, viewGroup, false);
            C0624a c0624a2 = new C0624a(view);
            view.setTag(c0624a2);
            c0624a = c0624a2;
        } else {
            c0624a = (C0624a) view.getTag();
        }
        com.baidu.tieba.ala.liveroom.challenge.a.a aVar = (com.baidu.tieba.ala.liveroom.challenge.a.a) getItem(i);
        if (aVar != null) {
            c0624a.a(i, aVar);
        }
        return view;
    }

    /* renamed from: com.baidu.tieba.ala.liveroom.challenge.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0624a {
        private ImageView gql;
        private TextView gqm;
        private TextView gqn;
        private TextView gqo;
        private HeadImageView gqp;

        public C0624a(View view) {
            this.gql = (ImageView) view.findViewById(a.g.id_jinzhu_item_rank_no_iv);
            this.gqm = (TextView) view.findViewById(a.g.id_jinzhu_item_rank_no_tv);
            this.gqn = (TextView) view.findViewById(a.g.id_jinzhu_item_pk_score);
            this.gqo = (TextView) view.findViewById(a.g.id_jinzhu_item_name);
            this.gqp = (HeadImageView) view.findViewById(a.g.id_jinzhu_item_head_iv);
            this.gqp.setIsRound(true);
            this.gqp.setAutoChangeStyle(false);
            this.gqp.setDefaultResource(a.f.sdk_pic_mycenter_avatar_def);
            this.gqp.setDefaultErrorResource(a.f.sdk_pic_mycenter_avatar_def);
        }

        public void a(int i, final com.baidu.tieba.ala.liveroom.challenge.a.a aVar) {
            if (aVar != null) {
                if (i == 0) {
                    this.gql.setVisibility(0);
                    this.gqm.setVisibility(4);
                    this.gql.setImageResource(a.f.icon_jinzhu_item_rank1);
                } else if (i == 1) {
                    this.gql.setVisibility(0);
                    this.gqm.setVisibility(4);
                    this.gql.setImageResource(a.f.icon_jinzhu_item_rank2);
                } else if (i == 2) {
                    this.gql.setVisibility(0);
                    this.gqm.setVisibility(4);
                    this.gql.setImageResource(a.f.icon_jinzhu_item_rank3);
                } else {
                    this.gql.setVisibility(4);
                    this.gqm.setVisibility(0);
                    this.gqm.setText(String.valueOf(i + 1));
                }
                if (aVar.aIl != null) {
                    k.a(this.gqp, aVar.aIl.portrait, true, false);
                    this.gqo.setText(aVar.aIl.nickName);
                }
                this.gqn.setText(aVar.score);
                this.gqp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.adapter.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        AlaLiveUserInfoData alaLiveUserInfoData = aVar.aIl;
                        if (alaLiveUserInfoData != null) {
                            a.this.mTbPageContext.getPageActivity().finish();
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(a.this.mTbPageContext.getPageActivity(), alaLiveUserInfoData.userId + "", alaLiveUserInfoData.userName, alaLiveUserInfoData.portrait, 0, 0, null, null, 0L, 0L, 0L, 0, null, String.valueOf(a.this.bew), a.this.mIsHost, String.valueOf(a.this.fuJ), null, alaLiveUserInfoData.userName, "")));
                        }
                    }
                });
            }
        }
    }
}
