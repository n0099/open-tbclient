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
    private long bmB;
    private long fSB;
    private ArrayList<com.baidu.tieba.ala.liveroom.challenge.a.a> fTO = new ArrayList<>();
    private boolean mIsHost;
    private TbPageContext mTbPageContext;
    private int mType;

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    public void setData(List<com.baidu.tieba.ala.liveroom.challenge.a.a> list) {
        if (this.fTO == null) {
            this.fTO = new ArrayList<>();
        } else {
            this.fTO.clear();
        }
        this.fTO.addAll(list);
        notifyDataSetChanged();
    }

    public void a(int i, long j, long j2, boolean z) {
        this.bmB = j;
        this.mIsHost = z;
        this.mType = i;
        this.fSB = j2;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fTO != null) {
            return this.fTO.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.fTO != null) {
            return this.fTO.get(i);
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
        C0654a c0654a;
        if (view == null) {
            view = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.h.ala_jinzhu_list_item_layout, viewGroup, false);
            C0654a c0654a2 = new C0654a(view);
            view.setTag(c0654a2);
            c0654a = c0654a2;
        } else {
            c0654a = (C0654a) view.getTag();
        }
        com.baidu.tieba.ala.liveroom.challenge.a.a aVar = (com.baidu.tieba.ala.liveroom.challenge.a.a) getItem(i);
        if (aVar != null) {
            c0654a.a(i, aVar);
        }
        return view;
    }

    /* renamed from: com.baidu.tieba.ala.liveroom.challenge.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0654a {
        private ImageView gTQ;
        private TextView gTR;
        private TextView gTS;
        private TextView gTT;
        private HeadImageView gTU;

        public C0654a(View view) {
            this.gTQ = (ImageView) view.findViewById(a.g.id_jinzhu_item_rank_no_iv);
            this.gTR = (TextView) view.findViewById(a.g.id_jinzhu_item_rank_no_tv);
            this.gTS = (TextView) view.findViewById(a.g.id_jinzhu_item_pk_score);
            this.gTT = (TextView) view.findViewById(a.g.id_jinzhu_item_name);
            this.gTU = (HeadImageView) view.findViewById(a.g.id_jinzhu_item_head_iv);
            this.gTU.setIsRound(true);
            this.gTU.setAutoChangeStyle(false);
            this.gTU.setDefaultResource(a.f.sdk_pic_mycenter_avatar_def);
            this.gTU.setDefaultErrorResource(a.f.sdk_pic_mycenter_avatar_def);
        }

        public void a(int i, final com.baidu.tieba.ala.liveroom.challenge.a.a aVar) {
            if (aVar != null) {
                if (i == 0) {
                    this.gTQ.setVisibility(0);
                    this.gTR.setVisibility(4);
                    this.gTQ.setImageResource(a.f.icon_jinzhu_item_rank1);
                } else if (i == 1) {
                    this.gTQ.setVisibility(0);
                    this.gTR.setVisibility(4);
                    this.gTQ.setImageResource(a.f.icon_jinzhu_item_rank2);
                } else if (i == 2) {
                    this.gTQ.setVisibility(0);
                    this.gTR.setVisibility(4);
                    this.gTQ.setImageResource(a.f.icon_jinzhu_item_rank3);
                } else {
                    this.gTQ.setVisibility(4);
                    this.gTR.setVisibility(0);
                    this.gTR.setText(String.valueOf(i + 1));
                }
                if (aVar.aNs != null) {
                    l.a(this.gTU, aVar.aNs.portrait, true, false);
                    this.gTT.setText(aVar.aNs.nickName);
                }
                this.gTS.setText(aVar.score);
                this.gTU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.adapter.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        AlaLiveUserInfoData alaLiveUserInfoData = aVar.aNs;
                        if (alaLiveUserInfoData != null) {
                            a.this.mTbPageContext.getPageActivity().finish();
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(a.this.mTbPageContext.getPageActivity(), alaLiveUserInfoData.userId + "", alaLiveUserInfoData.userName, alaLiveUserInfoData.portrait, 0, 0, null, null, 0L, 0L, 0L, 0, null, String.valueOf(a.this.bmB), a.this.mIsHost, String.valueOf(a.this.fSB), null, alaLiveUserInfoData.userName, "")));
                        }
                    }
                });
            }
        }
    }
}
