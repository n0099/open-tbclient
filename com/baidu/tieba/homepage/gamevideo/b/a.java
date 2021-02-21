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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.gamevideo.view.GameVideoGridView;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private TbPageContext eUY;
    private GameVideoGridView kfh;
    private com.baidu.tieba.homepage.gamevideo.a.b kfi;
    private InterfaceC0745a kfj;
    private BdUniqueId mBdUniqueId;
    private AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.a.1
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (a.this.kfi != null && i < a.this.kfi.getCount() && a.this.kfi.getItem(i) != null && (a.this.kfi.getItem(i) instanceof com.baidu.tieba.homepage.gamevideo.c.a)) {
                com.baidu.tieba.homepage.gamevideo.c.a aVar = (com.baidu.tieba.homepage.gamevideo.c.a) a.this.kfi.getItem(i);
                if (aVar.enable == 1) {
                    a.this.kfi.BO(aVar.sub_class_id);
                    if (a.this.kfj != null) {
                        a.this.kfj.a(aVar);
                    }
                    a.this.cQk();
                    com.baidu.tbadk.core.sharedPref.b.brQ().putInt("key_game_video_tab_has_choosed_sub_class_id", aVar.sub_class_id);
                    com.baidu.tbadk.core.sharedPref.b.brQ().putString("key_game_video_tab_has_choosed_sub_class_name", aVar.sub_class_name);
                    TiebaStatic.log(new ar("c13485").ap("obj_type", aVar.sub_class_id));
                }
            }
        }
    };
    private View mRootView;
    private TextView mTitle;

    /* renamed from: com.baidu.tieba.homepage.gamevideo.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0745a {
        void a(com.baidu.tieba.homepage.gamevideo.c.a aVar);
    }

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.eUY = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        init();
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.eUY.getPageActivity()).inflate(R.layout.game_video_choose_fullscreen_layout, (ViewGroup) null);
        this.kfh = (GameVideoGridView) this.mRootView.findViewById(R.id.id_game_video_choose_full_gridview);
        this.kfi = new com.baidu.tieba.homepage.gamevideo.a.b(this.eUY, 101, this.mBdUniqueId);
        this.kfh.setNumColumns(4);
        this.kfh.setAdapter((ListAdapter) this.kfi);
        this.kfh.setOnItemClickListener(this.mOnItemClickListener);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.id_game_video_choose_full_title);
        onChangeSkinType();
    }

    public void setData(List<com.baidu.tieba.homepage.gamevideo.c.a> list) {
        if (!y.isEmpty(list)) {
            this.kfi.setData(list);
            this.kfi.notifyDataSetChanged();
        }
    }

    public void onChangeSkinType() {
        if (this.mTitle != null) {
            ap.setViewTextColor(this.mTitle, R.color.CAM_X0105);
        }
        if (this.mRootView != null) {
            ap.setBackgroundResource(this.mRootView, R.color.CAM_X0201);
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

    public void cQk() {
        if (this.mRootView != null && this.mRootView.getParent() != null) {
            ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
        }
    }

    public void a(InterfaceC0745a interfaceC0745a) {
        this.kfj = interfaceC0745a;
    }

    public void onDestroy() {
        if (this.kfh != null) {
            this.kfh.onDestroy();
        }
    }
}
