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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.recent_history.b.b;
import java.util.List;
/* loaded from: classes4.dex */
public class c extends com.baidu.tieba.ala.alasquare.recent_history.a.a {
    private long giP;
    private a giQ;
    private Drawable mLeftDrawable;

    /* loaded from: classes4.dex */
    public interface a {
        void a(com.baidu.tieba.ala.alasquare.recent_history.b.b bVar);
    }

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.giP = com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
        this.mLeftDrawable = ap.getDrawable(this.mContext.getResources(), R.drawable.icon_video_direct_seeding);
    }

    public void a(a aVar) {
        this.giQ = aVar;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        int i2;
        if (view == null) {
            bVar = new b();
            view = LayoutInflater.from(this.mContext).inflate(R.layout.square_recent_history_whole_item, (ViewGroup) null);
            bVar.giL = (TbImageView) view.findViewById(R.id.recent_history_whole_img);
            bVar.giL.setDefaultResource(R.drawable.icon_default_avatar100_bg);
            bVar.giL.setIsRound(true);
            bVar.giL.setAutoChangeStyle(false);
            bVar.giL.setScaleType(ImageView.ScaleType.CENTER_CROP);
            bVar.dVL = (TextView) view.findViewById(R.id.recent_history_whole_user_name);
            bVar.giN = (TextView) view.findViewById(R.id.recent_history_whole_living_tag);
            bVar.giO = (TextView) view.findViewById(R.id.recent_history_whole_send_gift_tag);
            bVar.giT = (TextView) view.findViewById(R.id.recent_history_whole_live_begin_time);
            bVar.giU = (TextView) view.findViewById(R.id.recent_history_whole_follow_btn);
            bVar.giV = (TextView) view.findViewById(R.id.recent_history_whole_unfollow_btn);
            ap.setBackgroundColor(view, R.color.cp_bg_line_d);
            ap.setViewTextColor(bVar.dVL, R.color.cp_cont_b);
            ap.setViewTextColor(bVar.giT, R.color.cp_cont_d);
            ap.setViewTextColor(bVar.giU, R.color.cp_cont_e);
            ap.setViewTextColor(bVar.giV, R.color.square_follow_btn_txt_color);
            bVar.giN.setCompoundDrawablesWithIntrinsicBounds(this.mLeftDrawable, (Drawable) null, (Drawable) null, (Drawable) null);
            ap.setViewTextColor(bVar.giO, R.color.cp_cont_h);
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        final com.baidu.tieba.ala.alasquare.recent_history.b.b tQ = getItem(i);
        if (tQ != null && tQ.erH != null && tQ.erH.bka() != null) {
            final MetaData bka = tQ.erH.bka();
            bVar.giL.startLoad(bka.getPortrait(), 12, false);
            this.giI = 0;
            bVar.giN.setVisibility(8);
            bVar.giO.setVisibility(8);
            if (!y.isEmpty(tQ.tagList)) {
                for (b.a aVar : tQ.tagList) {
                    if (aVar != null) {
                        if (1 == aVar.aGP) {
                            bVar.giN.setVisibility(0);
                            if (!TextUtils.isEmpty(aVar.giY)) {
                                bVar.giN.setText(aVar.giY);
                            }
                            this.giI++;
                        } else if (2 == aVar.aGP) {
                            bVar.giO.setVisibility(0);
                            if (!TextUtils.isEmpty(aVar.giY)) {
                                bVar.giO.setText(aVar.giY);
                            }
                            this.giI++;
                        }
                    }
                }
            }
            boolean z = tQ.isFollow;
            String name_show = bka.getName_show();
            if (this.giI <= 1) {
                i2 = 14;
            } else {
                i2 = z ? 12 : 10;
            }
            bVar.dVL.setText(k.byteLength(name_show) > i2 ? at.cutChineseAndEnglishWithSuffix(name_show, i2, StringHelper.STRING_MORE) : name_show);
            bVar.giT.setText(at.getFormatTimeShort(tQ.giX * 1000));
            a(z, bVar);
            bVar.giV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.recent_history.a.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (c.this.giQ != null) {
                        c.this.giQ.a(tQ);
                    }
                }
            });
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.recent_history.a.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    boolean bV = c.this.bV(tQ.tagList);
                    aq aqVar = new aq("c12661");
                    aqVar.dR("obj_id", tQ.erH.bka().getUserId());
                    aqVar.aj("obj_type", bV ? 1 : 0);
                    TiebaStatic.log(aqVar);
                    if (!c.this.bV(tQ.tagList)) {
                        c.this.d(bka);
                    } else {
                        c.this.a(c.this.mPageContext, tQ.erH, "recent_history_whole_tab");
                    }
                }
            });
            aq aqVar = new aq("c12660");
            aqVar.dR("obj_id", tQ.erH.bka().getUserId());
            com.baidu.tieba.ala.alasquare.c.a.bNc().e(aqVar);
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bV(List<b.a> list) {
        if (!y.isEmpty(list)) {
            for (b.a aVar : list) {
                if (aVar != null && 1 == aVar.aGP) {
                    return true;
                }
            }
        }
        return false;
    }

    private void a(boolean z, b bVar) {
        if (z) {
            bVar.giV.setVisibility(8);
            bVar.giU.setVisibility(0);
            bVar.giU.setEnabled(false);
            return;
        }
        bVar.giU.setVisibility(8);
        bVar.giV.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tbadk.data.MetaData metaData) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.mContext).createNormalConfig(Long.valueOf(metaData.getUserId()).longValue(), String.valueOf(this.giP).equals(metaData.getUserId()), metaData.isBigV())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class b {
        public TextView dVL;
        public TbImageView giL;
        public TextView giN;
        public TextView giO;
        public TextView giT;
        public TextView giU;
        public TextView giV;

        private b() {
        }
    }
}
