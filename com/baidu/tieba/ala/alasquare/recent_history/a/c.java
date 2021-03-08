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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.recent_history.b.b;
import java.util.List;
/* loaded from: classes9.dex */
public class c extends com.baidu.tieba.ala.alasquare.recent_history.a.a {
    private Drawable gHA;
    private long gHy;
    private a gHz;

    /* loaded from: classes9.dex */
    public interface a {
        void a(com.baidu.tieba.ala.alasquare.recent_history.b.b bVar);
    }

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.gHy = com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
        this.gHA = ap.getDrawable(this.mContext.getResources(), R.drawable.icon_video_direct_seeding);
    }

    public void a(a aVar) {
        this.gHz = aVar;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        int i2;
        if (view == null) {
            bVar = new b();
            view = LayoutInflater.from(this.mContext).inflate(R.layout.square_recent_history_whole_item, (ViewGroup) null);
            bVar.gHu = (TbImageView) view.findViewById(R.id.recent_history_whole_img);
            bVar.gHu.setDefaultResource(R.drawable.icon_default_avatar100_bg);
            bVar.gHu.setIsRound(true);
            bVar.gHu.setAutoChangeStyle(false);
            bVar.gHu.setScaleType(ImageView.ScaleType.CENTER_CROP);
            bVar.eoT = (TextView) view.findViewById(R.id.recent_history_whole_user_name);
            bVar.gHw = (TextView) view.findViewById(R.id.recent_history_whole_living_tag);
            bVar.gHx = (TextView) view.findViewById(R.id.recent_history_whole_send_gift_tag);
            bVar.gHD = (TextView) view.findViewById(R.id.recent_history_whole_live_begin_time);
            bVar.gHE = (TextView) view.findViewById(R.id.recent_history_whole_follow_btn);
            bVar.gHF = (TextView) view.findViewById(R.id.recent_history_whole_unfollow_btn);
            ap.setBackgroundColor(view, R.color.CAM_X0201);
            ap.setViewTextColor(bVar.eoT, R.color.CAM_X0105);
            ap.setViewTextColor(bVar.gHD, R.color.CAM_X0109);
            ap.setViewTextColor(bVar.gHE, R.color.CAM_X0110);
            ap.setViewTextColor(bVar.gHF, R.color.square_follow_btn_txt_color);
            bVar.gHw.setCompoundDrawablesWithIntrinsicBounds(this.gHA, (Drawable) null, (Drawable) null, (Drawable) null);
            ap.setViewTextColor(bVar.gHx, R.color.CAM_X0301);
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        final com.baidu.tieba.ala.alasquare.recent_history.b.b tP = getItem(i);
        if (tP != null && tP.eLr != null && tP.eLr.bnS() != null) {
            final MetaData bnS = tP.eLr.bnS();
            bVar.gHu.startLoad(bnS.getPortrait(), 12, false);
            this.gHr = 0;
            bVar.gHw.setVisibility(8);
            bVar.gHx.setVisibility(8);
            if (!y.isEmpty(tP.tagList)) {
                for (b.a aVar : tP.tagList) {
                    if (aVar != null) {
                        if (1 == aVar.aHy) {
                            bVar.gHw.setVisibility(0);
                            if (!TextUtils.isEmpty(aVar.gHI)) {
                                bVar.gHw.setText(aVar.gHI);
                            }
                            this.gHr++;
                        } else if (2 == aVar.aHy) {
                            bVar.gHx.setVisibility(0);
                            if (!TextUtils.isEmpty(aVar.gHI)) {
                                bVar.gHx.setText(aVar.gHI);
                            }
                            this.gHr++;
                        }
                    }
                }
            }
            boolean z = tP.isFollow;
            String name_show = bnS.getName_show();
            if (this.gHr <= 1) {
                i2 = 14;
            } else {
                i2 = z ? 12 : 10;
            }
            bVar.eoT.setText(k.byteLength(name_show) > i2 ? au.cutChineseAndEnglishWithSuffix(name_show, i2, StringHelper.STRING_MORE) : name_show);
            bVar.gHD.setText(au.getFormatTimeShort(tP.gHH * 1000));
            a(z, bVar);
            bVar.gHF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.recent_history.a.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (c.this.gHz != null) {
                        c.this.gHz.a(tP);
                    }
                }
            });
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.recent_history.a.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    boolean ci = c.this.ci(tP.tagList);
                    ar arVar = new ar("c12661");
                    arVar.dR("obj_id", tP.eLr.bnS().getUserId());
                    arVar.aq("obj_type", ci ? 1 : 0);
                    TiebaStatic.log(arVar);
                    if (!c.this.ci(tP.tagList)) {
                        c.this.d(bnS);
                    } else {
                        c.this.a(c.this.mPageContext, tP.eLr, "recent_history_whole_tab");
                    }
                }
            });
            ar arVar = new ar("c12660");
            arVar.dR("obj_id", tP.eLr.bnS().getUserId());
            com.baidu.tieba.ala.alasquare.b.a.bSk().e(arVar);
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ci(List<b.a> list) {
        if (!y.isEmpty(list)) {
            for (b.a aVar : list) {
                if (aVar != null && 1 == aVar.aHy) {
                    return true;
                }
            }
        }
        return false;
    }

    private void a(boolean z, b bVar) {
        if (z) {
            bVar.gHF.setVisibility(8);
            bVar.gHE.setVisibility(0);
            bVar.gHE.setEnabled(false);
            return;
        }
        bVar.gHE.setVisibility(8);
        bVar.gHF.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tbadk.data.MetaData metaData) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.mContext).createNormalConfig(Long.valueOf(metaData.getUserId()).longValue(), String.valueOf(this.gHy).equals(metaData.getUserId()), metaData.isBigV())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class b {
        public TextView eoT;
        public TextView gHD;
        public TextView gHE;
        public TextView gHF;
        public TbImageView gHu;
        public TextView gHw;
        public TextView gHx;

        private b() {
        }
    }
}
