package com.baidu.tieba.ala;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.d.n;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.tieba.ala.data.o;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class h extends BaseAdapter {
    private ArrayList<o> eYq = new ArrayList<>();
    private TbPageContext mPageContext;

    public h(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void setData(List<o> list) {
        if (list != null) {
            this.eYq.clear();
            this.eYq.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.eYq.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.eYq.get(i);
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
        return ((o) getItem(i)).bXD();
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        b bVar;
        a aVar;
        int itemViewType = getItemViewType(i);
        if (view == null) {
            switch (itemViewType) {
                case 0:
                    view = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.g.ala_wish_list_empty_item_layout, (ViewGroup) null);
                    a aVar2 = new a(view);
                    view.setTag(aVar2);
                    bVar = null;
                    aVar = aVar2;
                    break;
                case 1:
                    view = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.g.ala_wish_list_item_layout, (ViewGroup) null);
                    b bVar2 = new b(view);
                    view.setTag(bVar2);
                    bVar = bVar2;
                    aVar = null;
                    break;
                default:
                    bVar = null;
                    aVar = null;
                    break;
            }
        } else {
            switch (itemViewType) {
                case 0:
                    bVar = null;
                    aVar = (a) view.getTag();
                    break;
                case 1:
                    bVar = (b) view.getTag();
                    aVar = null;
                    break;
                default:
                    bVar = null;
                    aVar = null;
                    break;
            }
        }
        final o oVar = (o) getItem(i);
        if (oVar != null) {
            switch (oVar.bXD()) {
                case 0:
                    if (aVar != null && aVar.rootView != null) {
                        aVar.rootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.h.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view2) {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new n(h.this.mPageContext.getPageActivity(), 1002, h.this.getCount())));
                            }
                        });
                        break;
                    }
                    break;
                case 1:
                    if (bVar != null) {
                        bVar.bbz.setText(oVar.getmName());
                        bVar.gsV.setText(oVar.bXE() + "个");
                        bVar.gsW.setText(oVar.bXG() + "小时");
                        String string = this.mPageContext.getResources().getString(a.h.add_wish_thank_way_txt);
                        if (!TextUtils.isEmpty(oVar.bXH())) {
                            string = oVar.bXH();
                        }
                        bVar.gsX.setText(string);
                        bVar.gsY.startLoad(oVar.bXF(), 10, false);
                        if (oVar.bXD() == 1) {
                            if (getItemId(i) == 0) {
                                bVar.gta.setImageResource(a.e.ala_wish_list_item_num_icon_no1);
                            } else if (getItemId(i) == 1) {
                                bVar.gta.setImageResource(a.e.ala_wish_list_item_num_icon_no2);
                            } else if (getItemId(i) == 2) {
                                bVar.gta.setImageResource(a.e.ala_wish_list_item_num_icon_no3);
                            }
                        }
                        if (bVar != null && bVar.rootView != null) {
                            bVar.rootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.h.2
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view2) {
                                }
                            });
                        }
                        bVar.gsZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.h.3
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view2) {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new com.baidu.live.d.f(h.this.mPageContext.getPageActivity(), oVar.bXI(), 1001, h.this.getItemId(i))));
                            }
                        });
                        break;
                    }
                    break;
            }
        }
        return view;
    }

    /* loaded from: classes11.dex */
    public static class a {
        public View rootView;

        public a(View view) {
            this.rootView = view;
        }
    }

    /* loaded from: classes11.dex */
    public static class b {
        public TextView bbz;
        public TextView gsV;
        public TextView gsW;
        public TextView gsX;
        public TbImageView gsY;
        public TbImageView gsZ;
        public TbImageView gta;
        public View rootView;

        public b(View view) {
            this.rootView = view;
            this.bbz = (TextView) view.findViewById(a.f.ala_wish_list_item_center_content_first_name);
            this.gsV = (TextView) view.findViewById(a.f.ala_wish_list_item_center_content_first_num);
            this.gsW = (TextView) view.findViewById(a.f.ala_wish_list_item_center_content_deadline_num);
            this.gsX = (TextView) view.findViewById(a.f.ala_wish_list_item_center_content_thank_way);
            this.gsY = (TbImageView) view.findViewById(a.f.ala_wish_list_item_icon);
            this.gsY.setDefaultBgResource(a.e.sdk_shape_transparent);
            this.gsZ = (TbImageView) view.findViewById(a.f.ala_wish_list_item_top_delete);
            this.gta = (TbImageView) view.findViewById(a.f.ala_wish_list_item_num_icon);
        }
    }
}
