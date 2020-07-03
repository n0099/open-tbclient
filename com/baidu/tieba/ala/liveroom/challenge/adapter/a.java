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
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private long aZe;
    private long fTw;
    private ArrayList<com.baidu.tieba.ala.liveroom.challenge.a.a> ffB = new ArrayList<>();
    private boolean mIsHost;
    private TbPageContext mTbPageContext;
    private int mType;

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    public void setData(List<com.baidu.tieba.ala.liveroom.challenge.a.a> list) {
        if (this.ffB == null) {
            this.ffB = new ArrayList<>();
        } else {
            this.ffB.clear();
        }
        this.ffB.addAll(list);
        notifyDataSetChanged();
    }

    public void a(int i, long j, long j2, boolean z) {
        this.aZe = j;
        this.mIsHost = z;
        this.mType = i;
        this.fTw = j2;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.ffB != null) {
            return this.ffB.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.ffB != null) {
            return this.ffB.get(i);
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
        C0567a c0567a;
        if (view == null) {
            view = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.h.ala_jinzhu_list_item_layout, viewGroup, false);
            C0567a c0567a2 = new C0567a(view);
            view.setTag(c0567a2);
            c0567a = c0567a2;
        } else {
            c0567a = (C0567a) view.getTag();
        }
        com.baidu.tieba.ala.liveroom.challenge.a.a aVar = (com.baidu.tieba.ala.liveroom.challenge.a.a) getItem(i);
        if (aVar != null) {
            c0567a.a(i, aVar);
        }
        return view;
    }

    /* renamed from: com.baidu.tieba.ala.liveroom.challenge.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0567a {
        private ImageView fYV;
        private TextView fYW;
        private TextView fYX;
        private TextView fYY;
        private HeadImageView fYZ;

        public C0567a(View view) {
            this.fYV = (ImageView) view.findViewById(a.g.id_jinzhu_item_rank_no_iv);
            this.fYW = (TextView) view.findViewById(a.g.id_jinzhu_item_rank_no_tv);
            this.fYX = (TextView) view.findViewById(a.g.id_jinzhu_item_pk_score);
            this.fYY = (TextView) view.findViewById(a.g.id_jinzhu_item_name);
            this.fYZ = (HeadImageView) view.findViewById(a.g.id_jinzhu_item_head_iv);
            this.fYZ.setIsRound(true);
            this.fYZ.setAutoChangeStyle(false);
            this.fYZ.setDefaultResource(a.f.sdk_pic_mycenter_avatar_def);
            this.fYZ.setDefaultErrorResource(a.f.sdk_pic_mycenter_avatar_def);
        }

        public void a(int i, final com.baidu.tieba.ala.liveroom.challenge.a.a aVar) {
            if (aVar != null) {
                if (i == 0) {
                    this.fYV.setVisibility(0);
                    this.fYW.setVisibility(4);
                    this.fYV.setImageResource(a.f.icon_jinzhu_item_rank1);
                } else if (i == 1) {
                    this.fYV.setVisibility(0);
                    this.fYW.setVisibility(4);
                    this.fYV.setImageResource(a.f.icon_jinzhu_item_rank2);
                } else if (i == 2) {
                    this.fYV.setVisibility(0);
                    this.fYW.setVisibility(4);
                    this.fYV.setImageResource(a.f.icon_jinzhu_item_rank3);
                } else {
                    this.fYV.setVisibility(4);
                    this.fYW.setVisibility(0);
                    this.fYW.setText(String.valueOf(i + 1));
                }
                if (aVar.aBG != null) {
                    k.a(this.fYZ, aVar.aBG.portrait, true, false);
                    this.fYY.setText(aVar.aBG.nickName);
                }
                this.fYX.setText(aVar.score);
                this.fYZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.adapter.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        AlaLiveUserInfoData alaLiveUserInfoData = aVar.aBG;
                        if (alaLiveUserInfoData != null) {
                            a.this.mTbPageContext.getPageActivity().finish();
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(a.this.mTbPageContext.getPageActivity(), alaLiveUserInfoData.userId + "", alaLiveUserInfoData.userName, alaLiveUserInfoData.portrait, 0, 0, null, null, 0L, 0L, 0L, 0, null, String.valueOf(a.this.aZe), a.this.mIsHost, String.valueOf(a.this.fTw), null, alaLiveUserInfoData.userName, "")));
                        }
                    }
                });
            }
        }
    }
}
