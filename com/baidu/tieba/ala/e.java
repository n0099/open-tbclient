package com.baidu.tieba.ala;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.c.j;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.u.a;
import com.baidu.tieba.ala.data.l;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class e extends BaseAdapter {
    private ArrayList<l> cVS = new ArrayList<>();
    private TbPageContext mPageContext;

    public e(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void setData(List<l> list) {
        if (list != null && this.cVS.size() < 4) {
            this.cVS.clear();
            this.cVS.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.cVS.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.cVS.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return ((l) getItem(i)).bes();
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        a aVar;
        b bVar = null;
        int itemViewType = getItemViewType(i);
        if (view == null) {
            switch (itemViewType) {
                case 0:
                    view = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.h.ala_wish_list_empty_item_layout, (ViewGroup) null);
                    a aVar2 = new a(view);
                    view.setTag(aVar2);
                    aVar = aVar2;
                    break;
                case 1:
                    view = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.h.ala_wish_list_item_layout, (ViewGroup) null);
                    b bVar2 = new b(view);
                    view.setTag(bVar2);
                    aVar = null;
                    bVar = bVar2;
                    break;
                default:
                    aVar = null;
                    break;
            }
        } else {
            switch (itemViewType) {
                case 0:
                    aVar = (a) view.getTag();
                    break;
                case 1:
                    aVar = null;
                    bVar = (b) view.getTag();
                    break;
                default:
                    aVar = null;
                    break;
            }
        }
        final l lVar = (l) getItem(i);
        if (lVar != null) {
            switch (lVar.bes()) {
                case 0:
                    if (aVar != null && aVar.rootView != null) {
                        aVar.rootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.e.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view2) {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new j(e.this.mPageContext.getPageActivity(), 1002, e.this.getCount())));
                            }
                        });
                        break;
                    }
                    break;
                case 1:
                    if (bVar != null) {
                        bVar.aiY.setText(lVar.getmName());
                        bVar.ejw.setText(lVar.bet() + "个");
                        bVar.ejx.setText(lVar.bev() + "小时");
                        String string = this.mPageContext.getResources().getString(a.i.add_wish_thank_way_txt);
                        if (!TextUtils.isEmpty(lVar.bew())) {
                            string = lVar.bew();
                        }
                        bVar.ejy.setText(string);
                        bVar.ejz.startLoad(lVar.beu(), 10, false);
                        if (lVar.bes() == 1) {
                            if (getItemId(i) == 0) {
                                bVar.ejB.setImageResource(a.f.ala_wish_list_item_num_icon_no1);
                            } else if (getItemId(i) == 1) {
                                bVar.ejB.setImageResource(a.f.ala_wish_list_item_num_icon_no2);
                            } else if (getItemId(i) == 2) {
                                bVar.ejB.setImageResource(a.f.ala_wish_list_item_num_icon_no3);
                            }
                        }
                        if (bVar != null && bVar.rootView != null) {
                            bVar.rootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.e.2
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view2) {
                                }
                            });
                        }
                        bVar.ejA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.e.3
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view2) {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new com.baidu.live.c.d(e.this.mPageContext.getPageActivity(), lVar.bex(), 1001, e.this.getItemId(i))));
                            }
                        });
                        break;
                    }
                    break;
            }
        }
        return view;
    }

    /* loaded from: classes3.dex */
    public static class a {
        public View rootView;

        public a(View view) {
            this.rootView = view;
        }
    }

    /* loaded from: classes3.dex */
    public static class b {
        public TextView aiY;
        public TbImageView ejA;
        public TbImageView ejB;
        public TextView ejw;
        public TextView ejx;
        public TextView ejy;
        public TbImageView ejz;
        public View rootView;

        public b(View view) {
            this.rootView = view;
            this.aiY = (TextView) view.findViewById(a.g.ala_wish_list_item_center_content_first_name);
            this.ejw = (TextView) view.findViewById(a.g.ala_wish_list_item_center_content_first_num);
            this.ejx = (TextView) view.findViewById(a.g.ala_wish_list_item_center_content_deadline_num);
            this.ejy = (TextView) view.findViewById(a.g.ala_wish_list_item_center_content_thank_way);
            this.ejz = (TbImageView) view.findViewById(a.g.ala_wish_list_item_icon);
            this.ejA = (TbImageView) view.findViewById(a.g.ala_wish_list_item_top_delete);
            this.ejB = (TbImageView) view.findViewById(a.g.ala_wish_list_item_num_icon);
        }
    }
}
