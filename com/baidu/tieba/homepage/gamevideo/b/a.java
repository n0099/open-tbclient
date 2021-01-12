package com.baidu.tieba.homepage.gamevideo.b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.gamevideo.view.GameVideoGridView;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private TbPageContext eSJ;
    private GameVideoGridView jXr;
    private com.baidu.tieba.homepage.gamevideo.a.b jXs;
    private InterfaceC0743a jXt;
    private BdUniqueId mBdUniqueId;
    private AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.a.1
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (a.this.jXs != null && i < a.this.jXs.getCount() && a.this.jXs.getItem(i) != null && (a.this.jXs.getItem(i) instanceof com.baidu.tieba.homepage.gamevideo.c.a)) {
                com.baidu.tieba.homepage.gamevideo.c.a aVar = (com.baidu.tieba.homepage.gamevideo.c.a) a.this.jXs.getItem(i);
                if (aVar.enable == 1) {
                    a.this.jXs.Bz(aVar.sub_class_id);
                    if (a.this.jXt != null) {
                        a.this.jXt.a(aVar);
                    }
                    a.this.cOg();
                    com.baidu.tbadk.core.sharedPref.b.brx().putInt("key_game_video_tab_has_choosed_sub_class_id", aVar.sub_class_id);
                    com.baidu.tbadk.core.sharedPref.b.brx().putString("key_game_video_tab_has_choosed_sub_class_name", aVar.sub_class_name);
                    TiebaStatic.log(new aq("c13485").an("obj_type", aVar.sub_class_id));
                }
            }
        }
    };
    private View mRootView;
    private TextView mTitle;

    /* renamed from: com.baidu.tieba.homepage.gamevideo.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0743a {
        void a(com.baidu.tieba.homepage.gamevideo.c.a aVar);
    }

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.eSJ = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        init();
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.eSJ.getPageActivity()).inflate(R.layout.game_video_choose_fullscreen_layout, (ViewGroup) null);
        this.jXr = (GameVideoGridView) this.mRootView.findViewById(R.id.id_game_video_choose_full_gridview);
        this.jXs = new com.baidu.tieba.homepage.gamevideo.a.b(this.eSJ, 101, this.mBdUniqueId);
        this.jXr.setNumColumns(4);
        this.jXr.setAdapter((ListAdapter) this.jXs);
        this.jXr.setOnItemClickListener(this.mOnItemClickListener);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.id_game_video_choose_full_title);
        onChangeSkinType();
    }

    public void setData(List<com.baidu.tieba.homepage.gamevideo.c.a> list) {
        if (!x.isEmpty(list)) {
            this.jXs.setData(list);
            this.jXs.notifyDataSetChanged();
        }
    }

    public void onChangeSkinType() {
        if (this.mTitle != null) {
            ao.setViewTextColor(this.mTitle, R.color.CAM_X0105);
        }
        if (this.mRootView != null) {
            ao.setBackgroundResource(this.mRootView, R.color.CAM_X0201);
        }
    }

    public void bT(ViewGroup viewGroup) {
        if (viewGroup != null && this.mRootView != null) {
            if (this.mRootView.getParent() != null) {
                ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
            }
            viewGroup.addView(this.mRootView);
            TiebaStatic.log("c13484");
        }
    }

    public void cOg() {
        if (this.mRootView != null && this.mRootView.getParent() != null) {
            ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
        }
    }

    public void a(InterfaceC0743a interfaceC0743a) {
        this.jXt = interfaceC0743a;
    }

    public void onDestroy() {
        if (this.jXr != null) {
            this.jXr.onDestroy();
        }
    }
}
