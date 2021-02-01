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
/* loaded from: classes10.dex */
public class c extends com.baidu.tieba.ala.alasquare.recent_history.a.a {
    private long gFB;
    private a gFC;
    private Drawable gFD;

    /* loaded from: classes10.dex */
    public interface a {
        void a(com.baidu.tieba.ala.alasquare.recent_history.b.b bVar);
    }

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.gFB = com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
        this.gFD = ap.getDrawable(this.mContext.getResources(), R.drawable.icon_video_direct_seeding);
    }

    public void a(a aVar) {
        this.gFC = aVar;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        int i2;
        if (view == null) {
            bVar = new b();
            view = LayoutInflater.from(this.mContext).inflate(R.layout.square_recent_history_whole_item, (ViewGroup) null);
            bVar.gFx = (TbImageView) view.findViewById(R.id.recent_history_whole_img);
            bVar.gFx.setDefaultResource(R.drawable.icon_default_avatar100_bg);
            bVar.gFx.setIsRound(true);
            bVar.gFx.setAutoChangeStyle(false);
            bVar.gFx.setScaleType(ImageView.ScaleType.CENTER_CROP);
            bVar.enq = (TextView) view.findViewById(R.id.recent_history_whole_user_name);
            bVar.gFz = (TextView) view.findViewById(R.id.recent_history_whole_living_tag);
            bVar.gFA = (TextView) view.findViewById(R.id.recent_history_whole_send_gift_tag);
            bVar.gFG = (TextView) view.findViewById(R.id.recent_history_whole_live_begin_time);
            bVar.gFH = (TextView) view.findViewById(R.id.recent_history_whole_follow_btn);
            bVar.gFI = (TextView) view.findViewById(R.id.recent_history_whole_unfollow_btn);
            ap.setBackgroundColor(view, R.color.CAM_X0201);
            ap.setViewTextColor(bVar.enq, R.color.CAM_X0105);
            ap.setViewTextColor(bVar.gFG, R.color.CAM_X0109);
            ap.setViewTextColor(bVar.gFH, R.color.CAM_X0110);
            ap.setViewTextColor(bVar.gFI, R.color.square_follow_btn_txt_color);
            bVar.gFz.setCompoundDrawablesWithIntrinsicBounds(this.gFD, (Drawable) null, (Drawable) null, (Drawable) null);
            ap.setViewTextColor(bVar.gFA, R.color.CAM_X0301);
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        final com.baidu.tieba.ala.alasquare.recent_history.b.b tN = getItem(i);
        if (tN != null && tN.eJQ != null && tN.eJQ.bnQ() != null) {
            final MetaData bnQ = tN.eJQ.bnQ();
            bVar.gFx.startLoad(bnQ.getPortrait(), 12, false);
            this.gFu = 0;
            bVar.gFz.setVisibility(8);
            bVar.gFA.setVisibility(8);
            if (!y.isEmpty(tN.tagList)) {
                for (b.a aVar : tN.tagList) {
                    if (aVar != null) {
                        if (1 == aVar.aFY) {
                            bVar.gFz.setVisibility(0);
                            if (!TextUtils.isEmpty(aVar.gFL)) {
                                bVar.gFz.setText(aVar.gFL);
                            }
                            this.gFu++;
                        } else if (2 == aVar.aFY) {
                            bVar.gFA.setVisibility(0);
                            if (!TextUtils.isEmpty(aVar.gFL)) {
                                bVar.gFA.setText(aVar.gFL);
                            }
                            this.gFu++;
                        }
                    }
                }
            }
            boolean z = tN.isFollow;
            String name_show = bnQ.getName_show();
            if (this.gFu <= 1) {
                i2 = 14;
            } else {
                i2 = z ? 12 : 10;
            }
            bVar.enq.setText(k.byteLength(name_show) > i2 ? au.cutChineseAndEnglishWithSuffix(name_show, i2, StringHelper.STRING_MORE) : name_show);
            bVar.gFG.setText(au.getFormatTimeShort(tN.gFK * 1000));
            a(z, bVar);
            bVar.gFI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.recent_history.a.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (c.this.gFC != null) {
                        c.this.gFC.a(tN);
                    }
                }
            });
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.recent_history.a.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    boolean ci = c.this.ci(tN.tagList);
                    ar arVar = new ar("c12661");
                    arVar.dR("obj_id", tN.eJQ.bnQ().getUserId());
                    arVar.ap("obj_type", ci ? 1 : 0);
                    TiebaStatic.log(arVar);
                    if (!c.this.ci(tN.tagList)) {
                        c.this.d(bnQ);
                    } else {
                        c.this.a(c.this.mPageContext, tN.eJQ, "recent_history_whole_tab");
                    }
                }
            });
            ar arVar = new ar("c12660");
            arVar.dR("obj_id", tN.eJQ.bnQ().getUserId());
            com.baidu.tieba.ala.alasquare.b.a.bRX().e(arVar);
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ci(List<b.a> list) {
        if (!y.isEmpty(list)) {
            for (b.a aVar : list) {
                if (aVar != null && 1 == aVar.aFY) {
                    return true;
                }
            }
        }
        return false;
    }

    private void a(boolean z, b bVar) {
        if (z) {
            bVar.gFI.setVisibility(8);
            bVar.gFH.setVisibility(0);
            bVar.gFH.setEnabled(false);
            return;
        }
        bVar.gFH.setVisibility(8);
        bVar.gFI.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tbadk.data.MetaData metaData) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.mContext).createNormalConfig(Long.valueOf(metaData.getUserId()).longValue(), String.valueOf(this.gFB).equals(metaData.getUserId()), metaData.isBigV())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class b {
        public TextView enq;
        public TextView gFA;
        public TextView gFG;
        public TextView gFH;
        public TextView gFI;
        public TbImageView gFx;
        public TextView gFz;

        private b() {
        }
    }
}
