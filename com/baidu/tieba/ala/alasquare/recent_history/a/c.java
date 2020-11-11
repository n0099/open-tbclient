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
    private long goC;
    private a goD;
    private Drawable mLeftDrawable;

    /* loaded from: classes4.dex */
    public interface a {
        void a(com.baidu.tieba.ala.alasquare.recent_history.b.b bVar);
    }

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.goC = com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
        this.mLeftDrawable = ap.getDrawable(this.mContext.getResources(), (int) R.drawable.icon_video_direct_seeding);
    }

    public void a(a aVar) {
        this.goD = aVar;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        int i2;
        if (view == null) {
            bVar = new b();
            view = LayoutInflater.from(this.mContext).inflate(R.layout.square_recent_history_whole_item, (ViewGroup) null);
            bVar.goy = (TbImageView) view.findViewById(R.id.recent_history_whole_img);
            bVar.goy.setDefaultResource(R.drawable.icon_default_avatar100_bg);
            bVar.goy.setIsRound(true);
            bVar.goy.setAutoChangeStyle(false);
            bVar.goy.setScaleType(ImageView.ScaleType.CENTER_CROP);
            bVar.ebD = (TextView) view.findViewById(R.id.recent_history_whole_user_name);
            bVar.goA = (TextView) view.findViewById(R.id.recent_history_whole_living_tag);
            bVar.goB = (TextView) view.findViewById(R.id.recent_history_whole_send_gift_tag);
            bVar.goG = (TextView) view.findViewById(R.id.recent_history_whole_live_begin_time);
            bVar.goH = (TextView) view.findViewById(R.id.recent_history_whole_follow_btn);
            bVar.goI = (TextView) view.findViewById(R.id.recent_history_whole_unfollow_btn);
            ap.setBackgroundColor(view, R.color.cp_bg_line_d);
            ap.setViewTextColor(bVar.ebD, (int) R.color.cp_cont_b);
            ap.setViewTextColor(bVar.goG, (int) R.color.cp_cont_d);
            ap.setViewTextColor(bVar.goH, (int) R.color.cp_cont_e);
            ap.setViewTextColor(bVar.goI, (int) R.color.square_follow_btn_txt_color);
            bVar.goA.setCompoundDrawablesWithIntrinsicBounds(this.mLeftDrawable, (Drawable) null, (Drawable) null, (Drawable) null);
            ap.setViewTextColor(bVar.goB, (int) R.color.cp_cont_h);
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        final com.baidu.tieba.ala.alasquare.recent_history.b.b ua = getItem(i);
        if (ua != null && ua.exA != null && ua.exA.bmA() != null) {
            final MetaData bmA = ua.exA.bmA();
            bVar.goy.startLoad(bmA.getPortrait(), 12, false);
            this.gov = 0;
            bVar.goA.setVisibility(8);
            bVar.goB.setVisibility(8);
            if (!y.isEmpty(ua.tagList)) {
                for (b.a aVar : ua.tagList) {
                    if (aVar != null) {
                        if (1 == aVar.aHF) {
                            bVar.goA.setVisibility(0);
                            if (!TextUtils.isEmpty(aVar.goL)) {
                                bVar.goA.setText(aVar.goL);
                            }
                            this.gov++;
                        } else if (2 == aVar.aHF) {
                            bVar.goB.setVisibility(0);
                            if (!TextUtils.isEmpty(aVar.goL)) {
                                bVar.goB.setText(aVar.goL);
                            }
                            this.gov++;
                        }
                    }
                }
            }
            boolean z = ua.isFollow;
            String name_show = bmA.getName_show();
            if (this.gov <= 1) {
                i2 = 14;
            } else {
                i2 = z ? 12 : 10;
            }
            bVar.ebD.setText(k.byteLength(name_show) > i2 ? at.cutChineseAndEnglishWithSuffix(name_show, i2, StringHelper.STRING_MORE) : name_show);
            bVar.goG.setText(at.getFormatTimeShort(ua.goK * 1000));
            a(z, bVar);
            bVar.goI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.recent_history.a.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (c.this.goD != null) {
                        c.this.goD.a(ua);
                    }
                }
            });
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.recent_history.a.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    boolean cc = c.this.cc(ua.tagList);
                    aq aqVar = new aq("c12661");
                    aqVar.dR("obj_id", ua.exA.bmA().getUserId());
                    aqVar.al("obj_type", cc ? 1 : 0);
                    TiebaStatic.log(aqVar);
                    if (!c.this.cc(ua.tagList)) {
                        c.this.d(bmA);
                    } else {
                        c.this.a(c.this.mPageContext, ua.exA, "recent_history_whole_tab");
                    }
                }
            });
            aq aqVar = new aq("c12660");
            aqVar.dR("obj_id", ua.exA.bmA().getUserId());
            com.baidu.tieba.ala.alasquare.c.a.bPC().e(aqVar);
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cc(List<b.a> list) {
        if (!y.isEmpty(list)) {
            for (b.a aVar : list) {
                if (aVar != null && 1 == aVar.aHF) {
                    return true;
                }
            }
        }
        return false;
    }

    private void a(boolean z, b bVar) {
        if (z) {
            bVar.goI.setVisibility(8);
            bVar.goH.setVisibility(0);
            bVar.goH.setEnabled(false);
            return;
        }
        bVar.goH.setVisibility(8);
        bVar.goI.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tbadk.data.MetaData metaData) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.mContext).createNormalConfig(Long.valueOf(metaData.getUserId()).longValue(), String.valueOf(this.goC).equals(metaData.getUserId()), metaData.isBigV())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class b {
        public TextView ebD;
        public TextView goA;
        public TextView goB;
        public TextView goG;
        public TextView goH;
        public TextView goI;
        public TbImageView goy;

        private b() {
        }
    }
}
