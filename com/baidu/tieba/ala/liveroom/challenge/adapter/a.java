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
    private long blh;
    private long fKh;
    private ArrayList<com.baidu.tieba.ala.liveroom.challenge.a.a> fLx = new ArrayList<>();
    private boolean mIsHost;
    private TbPageContext mTbPageContext;
    private int mType;

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    public void setData(List<com.baidu.tieba.ala.liveroom.challenge.a.a> list) {
        if (this.fLx == null) {
            this.fLx = new ArrayList<>();
        } else {
            this.fLx.clear();
        }
        this.fLx.addAll(list);
        notifyDataSetChanged();
    }

    public void a(int i, long j, long j2, boolean z) {
        this.blh = j;
        this.mIsHost = z;
        this.mType = i;
        this.fKh = j2;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fLx != null) {
            return this.fLx.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.fLx != null) {
            return this.fLx.get(i);
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
        C0638a c0638a;
        if (view == null) {
            view = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.h.ala_jinzhu_list_item_layout, viewGroup, false);
            C0638a c0638a2 = new C0638a(view);
            view.setTag(c0638a2);
            c0638a = c0638a2;
        } else {
            c0638a = (C0638a) view.getTag();
        }
        com.baidu.tieba.ala.liveroom.challenge.a.a aVar = (com.baidu.tieba.ala.liveroom.challenge.a.a) getItem(i);
        if (aVar != null) {
            c0638a.a(i, aVar);
        }
        return view;
    }

    /* renamed from: com.baidu.tieba.ala.liveroom.challenge.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0638a {
        private ImageView gIb;
        private TextView gIc;
        private TextView gId;
        private TextView gIe;
        private HeadImageView gIf;

        public C0638a(View view) {
            this.gIb = (ImageView) view.findViewById(a.g.id_jinzhu_item_rank_no_iv);
            this.gIc = (TextView) view.findViewById(a.g.id_jinzhu_item_rank_no_tv);
            this.gId = (TextView) view.findViewById(a.g.id_jinzhu_item_pk_score);
            this.gIe = (TextView) view.findViewById(a.g.id_jinzhu_item_name);
            this.gIf = (HeadImageView) view.findViewById(a.g.id_jinzhu_item_head_iv);
            this.gIf.setIsRound(true);
            this.gIf.setAutoChangeStyle(false);
            this.gIf.setDefaultResource(a.f.sdk_pic_mycenter_avatar_def);
            this.gIf.setDefaultErrorResource(a.f.sdk_pic_mycenter_avatar_def);
        }

        public void a(int i, final com.baidu.tieba.ala.liveroom.challenge.a.a aVar) {
            if (aVar != null) {
                if (i == 0) {
                    this.gIb.setVisibility(0);
                    this.gIc.setVisibility(4);
                    this.gIb.setImageResource(a.f.icon_jinzhu_item_rank1);
                } else if (i == 1) {
                    this.gIb.setVisibility(0);
                    this.gIc.setVisibility(4);
                    this.gIb.setImageResource(a.f.icon_jinzhu_item_rank2);
                } else if (i == 2) {
                    this.gIb.setVisibility(0);
                    this.gIc.setVisibility(4);
                    this.gIb.setImageResource(a.f.icon_jinzhu_item_rank3);
                } else {
                    this.gIb.setVisibility(4);
                    this.gIc.setVisibility(0);
                    this.gIc.setText(String.valueOf(i + 1));
                }
                if (aVar.aMN != null) {
                    l.a(this.gIf, aVar.aMN.portrait, true, false);
                    this.gIe.setText(aVar.aMN.nickName);
                }
                this.gId.setText(aVar.score);
                this.gIf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.adapter.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        AlaLiveUserInfoData alaLiveUserInfoData = aVar.aMN;
                        if (alaLiveUserInfoData != null) {
                            a.this.mTbPageContext.getPageActivity().finish();
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(a.this.mTbPageContext.getPageActivity(), alaLiveUserInfoData.userId + "", alaLiveUserInfoData.userName, alaLiveUserInfoData.portrait, 0, 0, null, null, 0L, 0L, 0L, 0, null, String.valueOf(a.this.blh), a.this.mIsHost, String.valueOf(a.this.fKh), null, alaLiveUserInfoData.userName, "")));
                        }
                    }
                });
            }
        }
    }
}
