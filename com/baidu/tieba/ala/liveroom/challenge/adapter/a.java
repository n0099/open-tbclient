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
    private long bey;
    private long fuN;
    private ArrayList<com.baidu.tieba.ala.liveroom.challenge.a.a> fwe = new ArrayList<>();
    private boolean mIsHost;
    private TbPageContext mTbPageContext;
    private int mType;

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    public void setData(List<com.baidu.tieba.ala.liveroom.challenge.a.a> list) {
        if (this.fwe == null) {
            this.fwe = new ArrayList<>();
        } else {
            this.fwe.clear();
        }
        this.fwe.addAll(list);
        notifyDataSetChanged();
    }

    public void a(int i, long j, long j2, boolean z) {
        this.bey = j;
        this.mIsHost = z;
        this.mType = i;
        this.fuN = j2;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fwe != null) {
            return this.fwe.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.fwe != null) {
            return this.fwe.get(i);
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
        private ImageView gqp;
        private TextView gqq;
        private TextView gqr;
        private TextView gqs;
        private HeadImageView gqt;

        public C0624a(View view) {
            this.gqp = (ImageView) view.findViewById(a.g.id_jinzhu_item_rank_no_iv);
            this.gqq = (TextView) view.findViewById(a.g.id_jinzhu_item_rank_no_tv);
            this.gqr = (TextView) view.findViewById(a.g.id_jinzhu_item_pk_score);
            this.gqs = (TextView) view.findViewById(a.g.id_jinzhu_item_name);
            this.gqt = (HeadImageView) view.findViewById(a.g.id_jinzhu_item_head_iv);
            this.gqt.setIsRound(true);
            this.gqt.setAutoChangeStyle(false);
            this.gqt.setDefaultResource(a.f.sdk_pic_mycenter_avatar_def);
            this.gqt.setDefaultErrorResource(a.f.sdk_pic_mycenter_avatar_def);
        }

        public void a(int i, final com.baidu.tieba.ala.liveroom.challenge.a.a aVar) {
            if (aVar != null) {
                if (i == 0) {
                    this.gqp.setVisibility(0);
                    this.gqq.setVisibility(4);
                    this.gqp.setImageResource(a.f.icon_jinzhu_item_rank1);
                } else if (i == 1) {
                    this.gqp.setVisibility(0);
                    this.gqq.setVisibility(4);
                    this.gqp.setImageResource(a.f.icon_jinzhu_item_rank2);
                } else if (i == 2) {
                    this.gqp.setVisibility(0);
                    this.gqq.setVisibility(4);
                    this.gqp.setImageResource(a.f.icon_jinzhu_item_rank3);
                } else {
                    this.gqp.setVisibility(4);
                    this.gqq.setVisibility(0);
                    this.gqq.setText(String.valueOf(i + 1));
                }
                if (aVar.aIn != null) {
                    k.a(this.gqt, aVar.aIn.portrait, true, false);
                    this.gqs.setText(aVar.aIn.nickName);
                }
                this.gqr.setText(aVar.score);
                this.gqt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.adapter.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        AlaLiveUserInfoData alaLiveUserInfoData = aVar.aIn;
                        if (alaLiveUserInfoData != null) {
                            a.this.mTbPageContext.getPageActivity().finish();
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(a.this.mTbPageContext.getPageActivity(), alaLiveUserInfoData.userId + "", alaLiveUserInfoData.userName, alaLiveUserInfoData.portrait, 0, 0, null, null, 0L, 0L, 0L, 0, null, String.valueOf(a.this.bey), a.this.mIsHost, String.valueOf(a.this.fuN), null, alaLiveUserInfoData.userName, "")));
                        }
                    }
                });
            }
        }
    }
}
