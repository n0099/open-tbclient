package com.baidu.tieba.homepage.gamevideo.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes2.dex */
public class b extends BaseAdapter {
    private boolean hasLoaded = false;
    private int keY;
    private int keZ;
    private BdUniqueId mBdUniqueId;
    private List<com.baidu.tieba.homepage.gamevideo.c.a> mList;
    private TbPageContext mTbPageContext;

    public b(TbPageContext tbPageContext, int i, BdUniqueId bdUniqueId) {
        this.keY = -1;
        this.mTbPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.keZ = i;
        this.keY = com.baidu.tbadk.core.sharedPref.b.brQ().getInt("key_game_video_tab_has_choosed_sub_class_id", -1);
    }

    public void setData(List<com.baidu.tieba.homepage.gamevideo.c.a> list) {
        this.mList = list;
        if (!this.hasLoaded && !y.isEmpty(list)) {
            for (com.baidu.tieba.homepage.gamevideo.c.a aVar : list) {
                if (!StringUtils.isNull(aVar.sub_class_icon)) {
                    com.baidu.adp.lib.e.d.mw().a(aVar.sub_class_icon, 10, null, this.mBdUniqueId);
                }
            }
            this.hasLoaded = true;
        }
    }

    public void BO(int i) {
        this.keY = i;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return y.getCount(this.mList);
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return y.getItem(this.mList, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            aVar = new a();
            view = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.game_video_choose_item_layout, (ViewGroup) null);
            aVar.title = (TextView) view.findViewById(R.id.id_game_video_choose_item_title);
            aVar.kfa = (BarImageView) view.findViewById(R.id.id_game_video_choose_item_photo);
            aVar.kfb = (ImageView) view.findViewById(R.id.id_game_video_choose_item_selected);
            aVar.kfa.setShowOval(true);
            aVar.kfa.setAutoChangeStyle(true);
            aVar.kfa.setBorderColor(this.mTbPageContext.getResources().getColor(R.color.black_alpha8));
            aVar.kfa.setBorderWidth(this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds3));
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        a(aVar);
        com.baidu.tieba.homepage.gamevideo.c.a aVar2 = (com.baidu.tieba.homepage.gamevideo.c.a) y.getItem(this.mList, i);
        if (aVar2 != null) {
            aVar.title.setText(StringUtils.isNull(aVar2.sub_class_name) ? "" : aVar2.sub_class_name);
            aVar.kfa.startLoad(aVar2.sub_class_icon, 10, false);
            if (aVar2.enable == 1) {
                aVar.kfa.setAlpha(1);
                aVar.title.setAlpha(1.0f);
            } else {
                aVar.kfa.setAlpha(0.5f);
                aVar.title.setAlpha(0.5f);
            }
            if (aVar2.sub_class_id == this.keY && this.keZ != 101) {
                aVar.kfb.setVisibility(0);
            } else {
                aVar.kfb.setVisibility(8);
            }
        }
        return view;
    }

    private void a(a aVar) {
        if (aVar != null) {
            ap.setViewTextColor(aVar.title, R.color.CAM_X0107);
            ap.setImageResource(aVar.kfb, R.drawable.icon_game_video_tab_choose_select);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a {
        BarImageView kfa;
        ImageView kfb;
        TextView title;

        private a() {
        }
    }
}
