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
/* loaded from: classes2.dex */
public class c extends com.baidu.tieba.ala.alasquare.recent_history.a.a {
    private long ekX;
    private a ekY;
    private Drawable mLeftDrawable;

    /* loaded from: classes2.dex */
    public interface a {
        void a(com.baidu.tieba.ala.alasquare.recent_history.b.b bVar);
    }

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.ekX = com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
        this.mLeftDrawable = am.getDrawable(this.mContext.getResources(), (int) R.drawable.icon_video_direct_seeding);
    }

    public void a(a aVar) {
        this.ekY = aVar;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        int i2;
        if (view == null) {
            bVar = new b();
            view = LayoutInflater.from(this.mContext).inflate(R.layout.square_recent_history_whole_item, (ViewGroup) null);
            bVar.ekT = (TbImageView) view.findViewById(R.id.recent_history_whole_img);
            bVar.ekT.setDefaultResource(R.drawable.icon_default_avatar100_bg);
            bVar.ekT.setIsRound(true);
            bVar.ekT.setAutoChangeStyle(false);
            bVar.ekT.setScaleType(ImageView.ScaleType.CENTER_CROP);
            bVar.cpT = (TextView) view.findViewById(R.id.recent_history_whole_user_name);
            bVar.ekV = (TextView) view.findViewById(R.id.recent_history_whole_living_tag);
            bVar.ekW = (TextView) view.findViewById(R.id.recent_history_whole_send_gift_tag);
            bVar.elb = (TextView) view.findViewById(R.id.recent_history_whole_live_begin_time);
            bVar.elc = (TextView) view.findViewById(R.id.recent_history_whole_follow_btn);
            bVar.eld = (TextView) view.findViewById(R.id.recent_history_whole_unfollow_btn);
            am.setBackgroundColor(view, R.color.cp_bg_line_d);
            am.setViewTextColor(bVar.cpT, (int) R.color.cp_cont_b);
            am.setViewTextColor(bVar.elb, (int) R.color.cp_cont_d);
            am.setViewTextColor(bVar.elc, (int) R.color.cp_cont_e);
            am.setViewTextColor(bVar.eld, (int) R.color.square_follow_btn_txt_color);
            bVar.ekV.setCompoundDrawablesWithIntrinsicBounds(this.mLeftDrawable, (Drawable) null, (Drawable) null, (Drawable) null);
            am.setViewTextColor(bVar.ekW, (int) R.color.cp_cont_h);
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        final com.baidu.tieba.ala.alasquare.recent_history.b.b or = getItem(i);
        if (or != null && or.cMR != null && or.cMR.azE() != null) {
            final MetaData azE = or.cMR.azE();
            bVar.ekT.startLoad(azE.getPortrait(), 12, false);
            this.ekQ = 0;
            bVar.ekV.setVisibility(8);
            bVar.ekW.setVisibility(8);
            if (!v.isEmpty(or.tagList)) {
                for (b.a aVar : or.tagList) {
                    if (aVar != null) {
                        if (1 == aVar.Vo) {
                            bVar.ekV.setVisibility(0);
                            if (!TextUtils.isEmpty(aVar.elg)) {
                                bVar.ekV.setText(aVar.elg);
                            }
                            this.ekQ++;
                        } else if (2 == aVar.Vo) {
                            bVar.ekW.setVisibility(0);
                            if (!TextUtils.isEmpty(aVar.elg)) {
                                bVar.ekW.setText(aVar.elg);
                            }
                            this.ekQ++;
                        }
                    }
                }
            }
            boolean z = or.isFollow;
            String name_show = azE.getName_show();
            if (this.ekQ <= 1) {
                i2 = 14;
            } else {
                i2 = z ? 12 : 10;
            }
            bVar.cpT.setText(k.byteLength(name_show) > i2 ? aq.cutChineseAndEnglishWithSuffix(name_show, i2, StringHelper.STRING_MORE) : name_show);
            bVar.elb.setText(aq.getFormatTimeShort(or.elf * 1000));
            a(z, bVar);
            bVar.eld.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.recent_history.a.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (c.this.ekY != null) {
                        c.this.ekY.a(or);
                    }
                }
            });
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.recent_history.a.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    boolean bk = c.this.bk(or.tagList);
                    an anVar = new an("c12661");
                    anVar.cp("obj_id", or.cMR.azE().getUserId());
                    anVar.Z("obj_type", bk ? 1 : 0);
                    TiebaStatic.log(anVar);
                    if (!c.this.bk(or.tagList)) {
                        c.this.d(azE);
                    } else {
                        c.this.a(c.this.mPageContext, or.cMR, "recent_history_whole_tab");
                    }
                }
            });
            an anVar = new an("c12660");
            anVar.cp("obj_id", or.cMR.azE().getUserId());
            com.baidu.tieba.ala.alasquare.c.a.bal().c(anVar);
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bk(List<b.a> list) {
        if (!v.isEmpty(list)) {
            for (b.a aVar : list) {
                if (aVar != null && 1 == aVar.Vo) {
                    return true;
                }
            }
        }
        return false;
    }

    private void a(boolean z, b bVar) {
        if (z) {
            bVar.eld.setVisibility(8);
            bVar.elc.setVisibility(0);
            bVar.elc.setEnabled(false);
            return;
        }
        bVar.elc.setVisibility(8);
        bVar.eld.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tbadk.data.MetaData metaData) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.mContext).createNormalConfig(Long.valueOf(metaData.getUserId()).longValue(), String.valueOf(this.ekX).equals(metaData.getUserId()), metaData.isBigV())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b {
        public TextView cpT;
        public TbImageView ekT;
        public TextView ekV;
        public TextView ekW;
        public TextView elb;
        public TextView elc;
        public TextView eld;

        private b() {
        }
    }
}
