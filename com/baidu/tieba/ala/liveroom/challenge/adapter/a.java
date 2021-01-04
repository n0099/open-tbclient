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
    private long bvY;
    private long gqJ;
    private ArrayList<com.baidu.tieba.ala.liveroom.challenge.a.a> grW = new ArrayList<>();
    private boolean mIsHost;
    private TbPageContext mTbPageContext;
    private int mType;

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    public void setData(List<com.baidu.tieba.ala.liveroom.challenge.a.a> list) {
        if (this.grW == null) {
            this.grW = new ArrayList<>();
        } else {
            this.grW.clear();
        }
        this.grW.addAll(list);
        notifyDataSetChanged();
    }

    public void b(int i, long j, long j2, boolean z) {
        this.bvY = j;
        this.mIsHost = z;
        this.mType = i;
        this.gqJ = j2;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.grW != null) {
            return this.grW.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.grW != null) {
            return this.grW.get(i);
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
        C0673a c0673a;
        if (view == null) {
            view = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.g.ala_jinzhu_list_item_layout, viewGroup, false);
            C0673a c0673a2 = new C0673a(view);
            view.setTag(c0673a2);
            c0673a = c0673a2;
        } else {
            c0673a = (C0673a) view.getTag();
        }
        com.baidu.tieba.ala.liveroom.challenge.a.a aVar = (com.baidu.tieba.ala.liveroom.challenge.a.a) getItem(i);
        if (aVar != null) {
            c0673a.a(i, aVar);
        }
        return view;
    }

    /* renamed from: com.baidu.tieba.ala.liveroom.challenge.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public class C0673a {
        private HeadImageView bEQ;
        private ImageView hvi;
        private TextView hvj;
        private TextView hvk;
        private TextView hvl;

        public C0673a(View view) {
            this.hvi = (ImageView) view.findViewById(a.f.id_jinzhu_item_rank_no_iv);
            this.hvj = (TextView) view.findViewById(a.f.id_jinzhu_item_rank_no_tv);
            this.hvk = (TextView) view.findViewById(a.f.id_jinzhu_item_pk_score);
            this.hvl = (TextView) view.findViewById(a.f.id_jinzhu_item_name);
            this.bEQ = (HeadImageView) view.findViewById(a.f.id_jinzhu_item_head_iv);
            this.bEQ.setIsRound(true);
            this.bEQ.setAutoChangeStyle(false);
            this.bEQ.setDefaultResource(a.e.sdk_pic_mycenter_avatar_def);
            this.bEQ.setDefaultErrorResource(a.e.sdk_pic_mycenter_avatar_def);
        }

        public void a(int i, final com.baidu.tieba.ala.liveroom.challenge.a.a aVar) {
            if (aVar != null) {
                if (i == 0) {
                    this.hvi.setVisibility(0);
                    this.hvj.setVisibility(4);
                    this.hvi.setImageResource(a.e.icon_jinzhu_item_rank1);
                } else if (i == 1) {
                    this.hvi.setVisibility(0);
                    this.hvj.setVisibility(4);
                    this.hvi.setImageResource(a.e.icon_jinzhu_item_rank2);
                } else if (i == 2) {
                    this.hvi.setVisibility(0);
                    this.hvj.setVisibility(4);
                    this.hvi.setImageResource(a.e.icon_jinzhu_item_rank3);
                } else {
                    this.hvi.setVisibility(4);
                    this.hvj.setVisibility(0);
                    this.hvj.setText(String.valueOf(i + 1));
                }
                if (aVar.aQy != null) {
                    m.a(this.bEQ, aVar.aQy.portrait, true, false);
                    this.hvl.setText(aVar.aQy.nickName);
                }
                this.hvk.setText(aVar.score);
                this.bEQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.adapter.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        AlaLiveUserInfoData alaLiveUserInfoData = aVar.aQy;
                        if (alaLiveUserInfoData != null) {
                            a.this.mTbPageContext.getPageActivity().finish();
                            AlaPersonCardActivityConfig alaPersonCardActivityConfig = new AlaPersonCardActivityConfig(a.this.mTbPageContext.getPageActivity(), alaLiveUserInfoData.userId + "", alaLiveUserInfoData.userName, alaLiveUserInfoData.portrait, 0, 0, null, null, 0L, 0L, 0L, 0, null, String.valueOf(a.this.bvY), a.this.mIsHost, String.valueOf(a.this.gqJ), null, alaLiveUserInfoData.userName);
                            alaPersonCardActivityConfig.setExtInfo(alaLiveUserInfoData.extInfoJson);
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaPersonCardActivityConfig));
                        }
                    }
                });
            }
        }
    }
}
