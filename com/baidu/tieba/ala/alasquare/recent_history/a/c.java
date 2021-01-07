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
/* loaded from: classes10.dex */
public class c extends com.baidu.tieba.ala.alasquare.recent_history.a.a {
    private long gHx;
    private a gHy;
    private Drawable gHz;

    /* loaded from: classes10.dex */
    public interface a {
        void a(com.baidu.tieba.ala.alasquare.recent_history.b.b bVar);
    }

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.gHx = com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
        this.gHz = ao.getDrawable(this.mContext.getResources(), R.drawable.icon_video_direct_seeding);
    }

    public void a(a aVar) {
        this.gHy = aVar;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        int i2;
        if (view == null) {
            bVar = new b();
            view = LayoutInflater.from(this.mContext).inflate(R.layout.square_recent_history_whole_item, (ViewGroup) null);
            bVar.gHt = (TbImageView) view.findViewById(R.id.recent_history_whole_img);
            bVar.gHt.setDefaultResource(R.drawable.icon_default_avatar100_bg);
            bVar.gHt.setIsRound(true);
            bVar.gHt.setAutoChangeStyle(false);
            bVar.gHt.setScaleType(ImageView.ScaleType.CENTER_CROP);
            bVar.epX = (TextView) view.findViewById(R.id.recent_history_whole_user_name);
            bVar.gHv = (TextView) view.findViewById(R.id.recent_history_whole_living_tag);
            bVar.gHw = (TextView) view.findViewById(R.id.recent_history_whole_send_gift_tag);
            bVar.gHC = (TextView) view.findViewById(R.id.recent_history_whole_live_begin_time);
            bVar.gHD = (TextView) view.findViewById(R.id.recent_history_whole_follow_btn);
            bVar.gHE = (TextView) view.findViewById(R.id.recent_history_whole_unfollow_btn);
            ao.setBackgroundColor(view, R.color.CAM_X0201);
            ao.setViewTextColor(bVar.epX, R.color.CAM_X0105);
            ao.setViewTextColor(bVar.gHC, R.color.CAM_X0109);
            ao.setViewTextColor(bVar.gHD, R.color.CAM_X0110);
            ao.setViewTextColor(bVar.gHE, R.color.square_follow_btn_txt_color);
            bVar.gHv.setCompoundDrawablesWithIntrinsicBounds(this.gHz, (Drawable) null, (Drawable) null, (Drawable) null);
            ao.setViewTextColor(bVar.gHw, R.color.CAM_X0301);
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        final com.baidu.tieba.ala.alasquare.recent_history.b.b vn = getItem(i);
        if (vn != null && vn.eMv != null && vn.eMv.brr() != null) {
            final MetaData brr = vn.eMv.brr();
            bVar.gHt.startLoad(brr.getPortrait(), 12, false);
            this.gHq = 0;
            bVar.gHv.setVisibility(8);
            bVar.gHw.setVisibility(8);
            if (!x.isEmpty(vn.tagList)) {
                for (b.a aVar : vn.tagList) {
                    if (aVar != null) {
                        if (1 == aVar.aIY) {
                            bVar.gHv.setVisibility(0);
                            if (!TextUtils.isEmpty(aVar.gHH)) {
                                bVar.gHv.setText(aVar.gHH);
                            }
                            this.gHq++;
                        } else if (2 == aVar.aIY) {
                            bVar.gHw.setVisibility(0);
                            if (!TextUtils.isEmpty(aVar.gHH)) {
                                bVar.gHw.setText(aVar.gHH);
                            }
                            this.gHq++;
                        }
                    }
                }
            }
            boolean z = vn.isFollow;
            String name_show = brr.getName_show();
            if (this.gHq <= 1) {
                i2 = 14;
            } else {
                i2 = z ? 12 : 10;
            }
            bVar.epX.setText(k.byteLength(name_show) > i2 ? at.cutChineseAndEnglishWithSuffix(name_show, i2, StringHelper.STRING_MORE) : name_show);
            bVar.gHC.setText(at.getFormatTimeShort(vn.gHG * 1000));
            a(z, bVar);
            bVar.gHE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.recent_history.a.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (c.this.gHy != null) {
                        c.this.gHy.a(vn);
                    }
                }
            });
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.recent_history.a.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    boolean cn2 = c.this.cn(vn.tagList);
                    aq aqVar = new aq("c12661");
                    aqVar.dX("obj_id", vn.eMv.brr().getUserId());
                    aqVar.an("obj_type", cn2 ? 1 : 0);
                    TiebaStatic.log(aqVar);
                    if (!c.this.cn(vn.tagList)) {
                        c.this.d(brr);
                    } else {
                        c.this.a(c.this.mPageContext, vn.eMv, "recent_history_whole_tab");
                    }
                }
            });
            aq aqVar = new aq("c12660");
            aqVar.dX("obj_id", vn.eMv.brr().getUserId());
            com.baidu.tieba.ala.alasquare.b.a.bVm().e(aqVar);
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cn(List<b.a> list) {
        if (!x.isEmpty(list)) {
            for (b.a aVar : list) {
                if (aVar != null && 1 == aVar.aIY) {
                    return true;
                }
            }
        }
        return false;
    }

    private void a(boolean z, b bVar) {
        if (z) {
            bVar.gHE.setVisibility(8);
            bVar.gHD.setVisibility(0);
            bVar.gHD.setEnabled(false);
            return;
        }
        bVar.gHD.setVisibility(8);
        bVar.gHE.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tbadk.data.MetaData metaData) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.mContext).createNormalConfig(Long.valueOf(metaData.getUserId()).longValue(), String.valueOf(this.gHx).equals(metaData.getUserId()), metaData.isBigV())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class b {
        public TextView epX;
        public TextView gHC;
        public TextView gHD;
        public TextView gHE;
        public TbImageView gHt;
        public TextView gHv;
        public TextView gHw;

        private b() {
        }
    }
}
