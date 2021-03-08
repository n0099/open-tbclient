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
    private long bwn;
    private long gqI;
    private ArrayList<com.baidu.tieba.ala.liveroom.challenge.a.a> grV = new ArrayList<>();
    private boolean mIsHost;
    private TbPageContext mTbPageContext;
    private int mType;

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    public void setData(List<com.baidu.tieba.ala.liveroom.challenge.a.a> list) {
        if (this.grV == null) {
            this.grV = new ArrayList<>();
        } else {
            this.grV.clear();
        }
        this.grV.addAll(list);
        notifyDataSetChanged();
    }

    public void b(int i, long j, long j2, boolean z) {
        this.bwn = j;
        this.mIsHost = z;
        this.mType = i;
        this.gqI = j2;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.grV != null) {
            return this.grV.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.grV != null) {
            return this.grV.get(i);
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
        C0665a c0665a;
        if (view == null) {
            view = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.g.ala_jinzhu_list_item_layout, viewGroup, false);
            C0665a c0665a2 = new C0665a(view);
            view.setTag(c0665a2);
            c0665a = c0665a2;
        } else {
            c0665a = (C0665a) view.getTag();
        }
        com.baidu.tieba.ala.liveroom.challenge.a.a aVar = (com.baidu.tieba.ala.liveroom.challenge.a.a) getItem(i);
        if (aVar != null) {
            c0665a.a(i, aVar);
        }
        return view;
    }

    /* renamed from: com.baidu.tieba.ala.liveroom.challenge.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public class C0665a {
        private HeadImageView bFk;
        private ImageView hwJ;
        private TextView hwK;
        private TextView hwL;
        private TextView hwM;

        public C0665a(View view) {
            this.hwJ = (ImageView) view.findViewById(a.f.id_jinzhu_item_rank_no_iv);
            this.hwK = (TextView) view.findViewById(a.f.id_jinzhu_item_rank_no_tv);
            this.hwL = (TextView) view.findViewById(a.f.id_jinzhu_item_pk_score);
            this.hwM = (TextView) view.findViewById(a.f.id_jinzhu_item_name);
            this.bFk = (HeadImageView) view.findViewById(a.f.id_jinzhu_item_head_iv);
            this.bFk.setIsRound(true);
            this.bFk.setAutoChangeStyle(false);
            this.bFk.setDefaultResource(a.e.sdk_icon_default_avatar100);
            this.bFk.setDefaultErrorResource(a.e.sdk_icon_default_avatar100);
        }

        public void a(int i, final com.baidu.tieba.ala.liveroom.challenge.a.a aVar) {
            if (aVar != null) {
                if (i == 0) {
                    this.hwJ.setVisibility(0);
                    this.hwK.setVisibility(4);
                    this.hwJ.setImageResource(a.e.icon_jinzhu_item_rank1);
                } else if (i == 1) {
                    this.hwJ.setVisibility(0);
                    this.hwK.setVisibility(4);
                    this.hwJ.setImageResource(a.e.icon_jinzhu_item_rank2);
                } else if (i == 2) {
                    this.hwJ.setVisibility(0);
                    this.hwK.setVisibility(4);
                    this.hwJ.setImageResource(a.e.icon_jinzhu_item_rank3);
                } else {
                    this.hwJ.setVisibility(4);
                    this.hwK.setVisibility(0);
                    this.hwK.setText(String.valueOf(i + 1));
                }
                if (aVar.aQi != null) {
                    m.a(this.bFk, aVar.aQi.portrait, true, false);
                    this.hwM.setText(aVar.aQi.nickName);
                }
                this.hwL.setText(aVar.score);
                this.bFk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.adapter.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        AlaLiveUserInfoData alaLiveUserInfoData = aVar.aQi;
                        if (alaLiveUserInfoData != null) {
                            a.this.mTbPageContext.getPageActivity().finish();
                            AlaPersonCardActivityConfig alaPersonCardActivityConfig = new AlaPersonCardActivityConfig(a.this.mTbPageContext.getPageActivity(), alaLiveUserInfoData.userId + "", alaLiveUserInfoData.userName, alaLiveUserInfoData.portrait, 0, 0, null, null, 0L, 0L, 0L, 0, null, String.valueOf(a.this.bwn), a.this.mIsHost, String.valueOf(a.this.gqI), null, alaLiveUserInfoData.userName);
                            alaPersonCardActivityConfig.setExtInfo(alaLiveUserInfoData.extInfoJson);
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaPersonCardActivityConfig));
                        }
                    }
                });
            }
        }
    }
}
