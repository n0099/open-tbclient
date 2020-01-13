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
    private long elT;
    private a elU;
    private Drawable mLeftDrawable;

    /* loaded from: classes2.dex */
    public interface a {
        void a(com.baidu.tieba.ala.alasquare.recent_history.b.b bVar);
    }

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.elT = com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
        this.mLeftDrawable = am.getDrawable(this.mContext.getResources(), (int) R.drawable.icon_video_direct_seeding);
    }

    public void a(a aVar) {
        this.elU = aVar;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        int i2;
        if (view == null) {
            bVar = new b();
            view = LayoutInflater.from(this.mContext).inflate(R.layout.square_recent_history_whole_item, (ViewGroup) null);
            bVar.elP = (TbImageView) view.findViewById(R.id.recent_history_whole_img);
            bVar.elP.setDefaultResource(R.drawable.icon_default_avatar100_bg);
            bVar.elP.setIsRound(true);
            bVar.elP.setAutoChangeStyle(false);
            bVar.elP.setScaleType(ImageView.ScaleType.CENTER_CROP);
            bVar.cqf = (TextView) view.findViewById(R.id.recent_history_whole_user_name);
            bVar.elR = (TextView) view.findViewById(R.id.recent_history_whole_living_tag);
            bVar.elS = (TextView) view.findViewById(R.id.recent_history_whole_send_gift_tag);
            bVar.elX = (TextView) view.findViewById(R.id.recent_history_whole_live_begin_time);
            bVar.elY = (TextView) view.findViewById(R.id.recent_history_whole_follow_btn);
            bVar.elZ = (TextView) view.findViewById(R.id.recent_history_whole_unfollow_btn);
            am.setBackgroundColor(view, R.color.cp_bg_line_d);
            am.setViewTextColor(bVar.cqf, (int) R.color.cp_cont_b);
            am.setViewTextColor(bVar.elX, (int) R.color.cp_cont_d);
            am.setViewTextColor(bVar.elY, (int) R.color.cp_cont_e);
            am.setViewTextColor(bVar.elZ, (int) R.color.square_follow_btn_txt_color);
            bVar.elR.setCompoundDrawablesWithIntrinsicBounds(this.mLeftDrawable, (Drawable) null, (Drawable) null, (Drawable) null);
            am.setViewTextColor(bVar.elS, (int) R.color.cp_cont_h);
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        final com.baidu.tieba.ala.alasquare.recent_history.b.b os = getItem(i);
        if (os != null && os.cNb != null && os.cNb.azX() != null) {
            final MetaData azX = os.cNb.azX();
            bVar.elP.startLoad(azX.getPortrait(), 12, false);
            this.elM = 0;
            bVar.elR.setVisibility(8);
            bVar.elS.setVisibility(8);
            if (!v.isEmpty(os.tagList)) {
                for (b.a aVar : os.tagList) {
                    if (aVar != null) {
                        if (1 == aVar.VE) {
                            bVar.elR.setVisibility(0);
                            if (!TextUtils.isEmpty(aVar.emc)) {
                                bVar.elR.setText(aVar.emc);
                            }
                            this.elM++;
                        } else if (2 == aVar.VE) {
                            bVar.elS.setVisibility(0);
                            if (!TextUtils.isEmpty(aVar.emc)) {
                                bVar.elS.setText(aVar.emc);
                            }
                            this.elM++;
                        }
                    }
                }
            }
            boolean z = os.isFollow;
            String name_show = azX.getName_show();
            if (this.elM <= 1) {
                i2 = 14;
            } else {
                i2 = z ? 12 : 10;
            }
            bVar.cqf.setText(k.byteLength(name_show) > i2 ? aq.cutChineseAndEnglishWithSuffix(name_show, i2, StringHelper.STRING_MORE) : name_show);
            bVar.elX.setText(aq.getFormatTimeShort(os.emb * 1000));
            a(z, bVar);
            bVar.elZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.recent_history.a.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (c.this.elU != null) {
                        c.this.elU.a(os);
                    }
                }
            });
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.recent_history.a.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    boolean bk = c.this.bk(os.tagList);
                    an anVar = new an("c12661");
                    anVar.cp("obj_id", os.cNb.azX().getUserId());
                    anVar.Z("obj_type", bk ? 1 : 0);
                    TiebaStatic.log(anVar);
                    if (!c.this.bk(os.tagList)) {
                        c.this.d(azX);
                    } else {
                        c.this.a(c.this.mPageContext, os.cNb, "recent_history_whole_tab");
                    }
                }
            });
            an anVar = new an("c12660");
            anVar.cp("obj_id", os.cNb.azX().getUserId());
            com.baidu.tieba.ala.alasquare.c.a.baG().c(anVar);
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bk(List<b.a> list) {
        if (!v.isEmpty(list)) {
            for (b.a aVar : list) {
                if (aVar != null && 1 == aVar.VE) {
                    return true;
                }
            }
        }
        return false;
    }

    private void a(boolean z, b bVar) {
        if (z) {
            bVar.elZ.setVisibility(8);
            bVar.elY.setVisibility(0);
            bVar.elY.setEnabled(false);
            return;
        }
        bVar.elY.setVisibility(8);
        bVar.elZ.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tbadk.data.MetaData metaData) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.mContext).createNormalConfig(Long.valueOf(metaData.getUserId()).longValue(), String.valueOf(this.elT).equals(metaData.getUserId()), metaData.isBigV())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b {
        public TextView cqf;
        public TbImageView elP;
        public TextView elR;
        public TextView elS;
        public TextView elX;
        public TextView elY;
        public TextView elZ;

        private b() {
        }
    }
}
