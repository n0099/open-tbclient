package com.baidu.tieba.ala.alasquare.recent_history.a;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.k;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.recent_history.b.b;
import java.util.List;
/* loaded from: classes9.dex */
public class c extends com.baidu.tieba.ala.alasquare.recent_history.a.a {
    private long gCR;
    private a gCS;
    private Drawable gCT;

    /* loaded from: classes9.dex */
    public interface a {
        void a(com.baidu.tieba.ala.alasquare.recent_history.b.b bVar);
    }

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.gCR = com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
        this.gCT = ao.getDrawable(this.mContext.getResources(), R.drawable.icon_video_direct_seeding);
    }

    public void a(a aVar) {
        this.gCS = aVar;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        int i2;
        if (view == null) {
            bVar = new b();
            view = LayoutInflater.from(this.mContext).inflate(R.layout.square_recent_history_whole_item, (ViewGroup) null);
            bVar.gCN = (TbImageView) view.findViewById(R.id.recent_history_whole_img);
            bVar.gCN.setDefaultResource(R.drawable.icon_default_avatar100_bg);
            bVar.gCN.setIsRound(true);
            bVar.gCN.setAutoChangeStyle(false);
            bVar.gCN.setScaleType(ImageView.ScaleType.CENTER_CROP);
            bVar.eli = (TextView) view.findViewById(R.id.recent_history_whole_user_name);
            bVar.gCP = (TextView) view.findViewById(R.id.recent_history_whole_living_tag);
            bVar.gCQ = (TextView) view.findViewById(R.id.recent_history_whole_send_gift_tag);
            bVar.gCW = (TextView) view.findViewById(R.id.recent_history_whole_live_begin_time);
            bVar.gCX = (TextView) view.findViewById(R.id.recent_history_whole_follow_btn);
            bVar.gCY = (TextView) view.findViewById(R.id.recent_history_whole_unfollow_btn);
            ao.setBackgroundColor(view, R.color.CAM_X0201);
            ao.setViewTextColor(bVar.eli, R.color.CAM_X0105);
            ao.setViewTextColor(bVar.gCW, R.color.CAM_X0109);
            ao.setViewTextColor(bVar.gCX, R.color.CAM_X0110);
            ao.setViewTextColor(bVar.gCY, R.color.square_follow_btn_txt_color);
            bVar.gCP.setCompoundDrawablesWithIntrinsicBounds(this.gCT, (Drawable) null, (Drawable) null, (Drawable) null);
            ao.setViewTextColor(bVar.gCQ, R.color.CAM_X0301);
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        final com.baidu.tieba.ala.alasquare.recent_history.b.b tH = getItem(i);
        if (tH != null && tH.eHK != null && tH.eHK.bnx() != null) {
            final MetaData bnx = tH.eHK.bnx();
            bVar.gCN.startLoad(bnx.getPortrait(), 12, false);
            this.gCK = 0;
            bVar.gCP.setVisibility(8);
            bVar.gCQ.setVisibility(8);
            if (!x.isEmpty(tH.tagList)) {
                for (b.a aVar : tH.tagList) {
                    if (aVar != null) {
                        if (1 == aVar.aEl) {
                            bVar.gCP.setVisibility(0);
                            if (!TextUtils.isEmpty(aVar.gDb)) {
                                bVar.gCP.setText(aVar.gDb);
                            }
                            this.gCK++;
                        } else if (2 == aVar.aEl) {
                            bVar.gCQ.setVisibility(0);
                            if (!TextUtils.isEmpty(aVar.gDb)) {
                                bVar.gCQ.setText(aVar.gDb);
                            }
                            this.gCK++;
                        }
                    }
                }
            }
            boolean z = tH.isFollow;
            String name_show = bnx.getName_show();
            if (this.gCK <= 1) {
                i2 = 14;
            } else {
                i2 = z ? 12 : 10;
            }
            bVar.eli.setText(k.byteLength(name_show) > i2 ? at.cutChineseAndEnglishWithSuffix(name_show, i2, StringHelper.STRING_MORE) : name_show);
            bVar.gCW.setText(at.getFormatTimeShort(tH.gDa * 1000));
            a(z, bVar);
            bVar.gCY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.recent_history.a.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (c.this.gCS != null) {
                        c.this.gCS.a(tH);
                    }
                }
            });
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.recent_history.a.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    boolean cn2 = c.this.cn(tH.tagList);
                    aq aqVar = new aq("c12661");
                    aqVar.dW("obj_id", tH.eHK.bnx().getUserId());
                    aqVar.an("obj_type", cn2 ? 1 : 0);
                    TiebaStatic.log(aqVar);
                    if (!c.this.cn(tH.tagList)) {
                        c.this.d(bnx);
                    } else {
                        c.this.a(c.this.mPageContext, tH.eHK, "recent_history_whole_tab");
                    }
                }
            });
            aq aqVar = new aq("c12660");
            aqVar.dW("obj_id", tH.eHK.bnx().getUserId());
            com.baidu.tieba.ala.alasquare.b.a.bRu().e(aqVar);
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cn(List<b.a> list) {
        if (!x.isEmpty(list)) {
            for (b.a aVar : list) {
                if (aVar != null && 1 == aVar.aEl) {
                    return true;
                }
            }
        }
        return false;
    }

    private void a(boolean z, b bVar) {
        if (z) {
            bVar.gCY.setVisibility(8);
            bVar.gCX.setVisibility(0);
            bVar.gCX.setEnabled(false);
            return;
        }
        bVar.gCX.setVisibility(8);
        bVar.gCY.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tbadk.data.MetaData metaData) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.mContext).createNormalConfig(Long.valueOf(metaData.getUserId()).longValue(), String.valueOf(this.gCR).equals(metaData.getUserId()), metaData.isBigV())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class b {
        public TextView eli;
        public TbImageView gCN;
        public TextView gCP;
        public TextView gCQ;
        public TextView gCW;
        public TextView gCX;
        public TextView gCY;

        private b() {
        }
    }
}
