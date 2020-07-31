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
/* loaded from: classes4.dex */
public class a extends BaseAdapter {
    private long aZc;
    private long fjn;
    private ArrayList<com.baidu.tieba.ala.liveroom.challenge.a.a> fkE = new ArrayList<>();
    private boolean mIsHost;
    private TbPageContext mTbPageContext;
    private int mType;

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    public void setData(List<com.baidu.tieba.ala.liveroom.challenge.a.a> list) {
        if (this.fkE == null) {
            this.fkE = new ArrayList<>();
        } else {
            this.fkE.clear();
        }
        this.fkE.addAll(list);
        notifyDataSetChanged();
    }

    public void a(int i, long j, long j2, boolean z) {
        this.aZc = j;
        this.mIsHost = z;
        this.mType = i;
        this.fjn = j2;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fkE != null) {
            return this.fkE.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.fkE != null) {
            return this.fkE.get(i);
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
        C0577a c0577a;
        if (view == null) {
            view = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.h.ala_jinzhu_list_item_layout, viewGroup, false);
            C0577a c0577a2 = new C0577a(view);
            view.setTag(c0577a2);
            c0577a = c0577a2;
        } else {
            c0577a = (C0577a) view.getTag();
        }
        com.baidu.tieba.ala.liveroom.challenge.a.a aVar = (com.baidu.tieba.ala.liveroom.challenge.a.a) getItem(i);
        if (aVar != null) {
            c0577a.a(i, aVar);
        }
        return view;
    }

    /* renamed from: com.baidu.tieba.ala.liveroom.challenge.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0577a {
        private ImageView gec;
        private TextView ged;
        private TextView gee;
        private TextView gef;
        private HeadImageView geg;

        public C0577a(View view) {
            this.gec = (ImageView) view.findViewById(a.g.id_jinzhu_item_rank_no_iv);
            this.ged = (TextView) view.findViewById(a.g.id_jinzhu_item_rank_no_tv);
            this.gee = (TextView) view.findViewById(a.g.id_jinzhu_item_pk_score);
            this.gef = (TextView) view.findViewById(a.g.id_jinzhu_item_name);
            this.geg = (HeadImageView) view.findViewById(a.g.id_jinzhu_item_head_iv);
            this.geg.setIsRound(true);
            this.geg.setAutoChangeStyle(false);
            this.geg.setDefaultResource(a.f.sdk_pic_mycenter_avatar_def);
            this.geg.setDefaultErrorResource(a.f.sdk_pic_mycenter_avatar_def);
        }

        public void a(int i, final com.baidu.tieba.ala.liveroom.challenge.a.a aVar) {
            if (aVar != null) {
                if (i == 0) {
                    this.gec.setVisibility(0);
                    this.ged.setVisibility(4);
                    this.gec.setImageResource(a.f.icon_jinzhu_item_rank1);
                } else if (i == 1) {
                    this.gec.setVisibility(0);
                    this.ged.setVisibility(4);
                    this.gec.setImageResource(a.f.icon_jinzhu_item_rank2);
                } else if (i == 2) {
                    this.gec.setVisibility(0);
                    this.ged.setVisibility(4);
                    this.gec.setImageResource(a.f.icon_jinzhu_item_rank3);
                } else {
                    this.gec.setVisibility(4);
                    this.ged.setVisibility(0);
                    this.ged.setText(String.valueOf(i + 1));
                }
                if (aVar.aDb != null) {
                    k.a(this.geg, aVar.aDb.portrait, true, false);
                    this.gef.setText(aVar.aDb.nickName);
                }
                this.gee.setText(aVar.score);
                this.geg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.adapter.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        AlaLiveUserInfoData alaLiveUserInfoData = aVar.aDb;
                        if (alaLiveUserInfoData != null) {
                            a.this.mTbPageContext.getPageActivity().finish();
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(a.this.mTbPageContext.getPageActivity(), alaLiveUserInfoData.userId + "", alaLiveUserInfoData.userName, alaLiveUserInfoData.portrait, 0, 0, null, null, 0L, 0L, 0L, 0, null, String.valueOf(a.this.aZc), a.this.mIsHost, String.valueOf(a.this.fjn), null, alaLiveUserInfoData.userName, "")));
                        }
                    }
                });
            }
        }
    }
}
