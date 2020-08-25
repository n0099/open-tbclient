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
/* loaded from: classes16.dex */
public class b extends BaseAdapter {
    private boolean hasLoaded = false;
    private int iJV;
    private int iJW;
    private BdUniqueId mBdUniqueId;
    private List<com.baidu.tieba.homepage.gamevideo.c.a> mList;
    private TbPageContext mTbPageContext;

    public b(TbPageContext tbPageContext, int i, BdUniqueId bdUniqueId) {
        this.iJV = -1;
        this.mTbPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.iJW = i;
        this.iJV = com.baidu.tbadk.core.sharedPref.b.bik().getInt("key_game_video_tab_has_choosed_sub_class_id", -1);
    }

    public void setData(List<com.baidu.tieba.homepage.gamevideo.c.a> list) {
        this.mList = list;
        if (!this.hasLoaded && !y.isEmpty(list)) {
            for (com.baidu.tieba.homepage.gamevideo.c.a aVar : list) {
                if (!StringUtils.isNull(aVar.sub_class_icon)) {
                    com.baidu.adp.lib.e.c.mM().a(aVar.sub_class_icon, 10, null, this.mBdUniqueId);
                }
            }
            this.hasLoaded = true;
        }
    }

    public void zR(int i) {
        this.iJV = i;
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
            aVar.iJX = (BarImageView) view.findViewById(R.id.id_game_video_choose_item_photo);
            aVar.iJY = (ImageView) view.findViewById(R.id.id_game_video_choose_item_selected);
            aVar.iJX.setShowOval(true);
            aVar.iJX.setAutoChangeStyle(true);
            aVar.iJX.setBorderColor(this.mTbPageContext.getResources().getColor(R.color.black_alpha8));
            aVar.iJX.setBorderWidth(this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds3));
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        a(aVar);
        com.baidu.tieba.homepage.gamevideo.c.a aVar2 = (com.baidu.tieba.homepage.gamevideo.c.a) y.getItem(this.mList, i);
        if (aVar2 != null) {
            aVar.title.setText(StringUtils.isNull(aVar2.sub_class_name) ? "" : aVar2.sub_class_name);
            aVar.iJX.startLoad(aVar2.sub_class_icon, 10, false);
            if (aVar2.enable == 1) {
                aVar.iJX.setAlpha(1);
                aVar.title.setAlpha(1.0f);
            } else {
                aVar.iJX.setAlpha(0.5f);
                aVar.title.setAlpha(0.5f);
            }
            if (aVar2.sub_class_id == this.iJV && this.iJW != 101) {
                aVar.iJY.setVisibility(0);
            } else {
                aVar.iJY.setVisibility(8);
            }
        }
        return view;
    }

    private void a(a aVar) {
        if (aVar != null) {
            ap.setViewTextColor(aVar.title, R.color.cp_cont_j);
            ap.setImageResource(aVar.iJY, R.drawable.icon_game_video_tab_choose_select);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes16.dex */
    public class a {
        BarImageView iJX;
        ImageView iJY;
        TextView title;

        private a() {
        }
    }
}
