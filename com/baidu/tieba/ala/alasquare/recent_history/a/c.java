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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.recent_history.b.b;
import java.util.List;
/* loaded from: classes3.dex */
public class c extends com.baidu.tieba.ala.alasquare.recent_history.a.a {
    private long eUt;
    private a eUu;
    private Drawable mLeftDrawable;

    /* loaded from: classes3.dex */
    public interface a {
        void a(com.baidu.tieba.ala.alasquare.recent_history.b.b bVar);
    }

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.eUt = com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
        this.mLeftDrawable = am.getDrawable(this.mContext.getResources(), (int) R.drawable.icon_video_direct_seeding);
    }

    public void a(a aVar) {
        this.eUu = aVar;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        int i2;
        if (view == null) {
            bVar = new b();
            view = LayoutInflater.from(this.mContext).inflate(R.layout.square_recent_history_whole_item, (ViewGroup) null);
            bVar.eUp = (TbImageView) view.findViewById(R.id.recent_history_whole_img);
            bVar.eUp.setDefaultResource(R.drawable.icon_default_avatar100_bg);
            bVar.eUp.setIsRound(true);
            bVar.eUp.setAutoChangeStyle(false);
            bVar.eUp.setScaleType(ImageView.ScaleType.CENTER_CROP);
            bVar.cTw = (TextView) view.findViewById(R.id.recent_history_whole_user_name);
            bVar.eUr = (TextView) view.findViewById(R.id.recent_history_whole_living_tag);
            bVar.eUs = (TextView) view.findViewById(R.id.recent_history_whole_send_gift_tag);
            bVar.eUx = (TextView) view.findViewById(R.id.recent_history_whole_live_begin_time);
            bVar.eUy = (TextView) view.findViewById(R.id.recent_history_whole_follow_btn);
            bVar.eUz = (TextView) view.findViewById(R.id.recent_history_whole_unfollow_btn);
            am.setBackgroundColor(view, R.color.cp_bg_line_d);
            am.setViewTextColor(bVar.cTw, (int) R.color.cp_cont_b);
            am.setViewTextColor(bVar.eUx, (int) R.color.cp_cont_d);
            am.setViewTextColor(bVar.eUy, (int) R.color.cp_cont_e);
            am.setViewTextColor(bVar.eUz, (int) R.color.square_follow_btn_txt_color);
            bVar.eUr.setCompoundDrawablesWithIntrinsicBounds(this.mLeftDrawable, (Drawable) null, (Drawable) null, (Drawable) null);
            am.setViewTextColor(bVar.eUs, (int) R.color.cp_cont_h);
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        final com.baidu.tieba.ala.alasquare.recent_history.b.b pe = getItem(i);
        if (pe != null && pe.dqE != null && pe.dqE.aKC() != null) {
            final MetaData aKC = pe.dqE.aKC();
            bVar.eUp.startLoad(aKC.getPortrait(), 12, false);
            this.eUm = 0;
            bVar.eUr.setVisibility(8);
            bVar.eUs.setVisibility(8);
            if (!v.isEmpty(pe.tagList)) {
                for (b.a aVar : pe.tagList) {
                    if (aVar != null) {
                        if (1 == aVar.apD) {
                            bVar.eUr.setVisibility(0);
                            if (!TextUtils.isEmpty(aVar.eUC)) {
                                bVar.eUr.setText(aVar.eUC);
                            }
                            this.eUm++;
                        } else if (2 == aVar.apD) {
                            bVar.eUs.setVisibility(0);
                            if (!TextUtils.isEmpty(aVar.eUC)) {
                                bVar.eUs.setText(aVar.eUC);
                            }
                            this.eUm++;
                        }
                    }
                }
            }
            boolean z = pe.isFollow;
            String name_show = aKC.getName_show();
            if (this.eUm <= 1) {
                i2 = 14;
            } else {
                i2 = z ? 12 : 10;
            }
            bVar.cTw.setText(k.byteLength(name_show) > i2 ? aq.cutChineseAndEnglishWithSuffix(name_show, i2, StringHelper.STRING_MORE) : name_show);
            bVar.eUx.setText(aq.getFormatTimeShort(pe.eUB * 1000));
            a(z, bVar);
            bVar.eUz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.recent_history.a.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (c.this.eUu != null) {
                        c.this.eUu.a(pe);
                    }
                }
            });
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.recent_history.a.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    boolean bu = c.this.bu(pe.tagList);
                    an anVar = new an("c12661");
                    anVar.cI("obj_id", pe.dqE.aKC().getUserId());
                    anVar.af("obj_type", bu ? 1 : 0);
                    TiebaStatic.log(anVar);
                    if (!c.this.bu(pe.tagList)) {
                        c.this.d(aKC);
                    } else {
                        c.this.a(c.this.mPageContext, pe.dqE, "recent_history_whole_tab");
                    }
                }
            });
            an anVar = new an("c12660");
            anVar.cI("obj_id", pe.dqE.aKC().getUserId());
            com.baidu.tieba.ala.alasquare.c.a.blS().e(anVar);
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bu(List<b.a> list) {
        if (!v.isEmpty(list)) {
            for (b.a aVar : list) {
                if (aVar != null && 1 == aVar.apD) {
                    return true;
                }
            }
        }
        return false;
    }

    private void a(boolean z, b bVar) {
        if (z) {
            bVar.eUz.setVisibility(8);
            bVar.eUy.setVisibility(0);
            bVar.eUy.setEnabled(false);
            return;
        }
        bVar.eUy.setVisibility(8);
        bVar.eUz.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tbadk.data.MetaData metaData) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.mContext).createNormalConfig(Long.valueOf(metaData.getUserId()).longValue(), String.valueOf(this.eUt).equals(metaData.getUserId()), metaData.isBigV())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b {
        public TextView cTw;
        public TbImageView eUp;
        public TextView eUr;
        public TextView eUs;
        public TextView eUx;
        public TextView eUy;
        public TextView eUz;

        private b() {
        }
    }
}
