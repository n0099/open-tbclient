package com.baidu.tieba.im.chat.officialBar;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes25.dex */
public class d extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<com.baidu.tbadk.mvc.b.a> air = new ArrayList<>();
    private c jqF;
    private TbPageContext<?> mPageContext;

    /* loaded from: classes25.dex */
    public interface c {
        void a(View view, Object obj, int i, long j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(TbPageContext<?> tbPageContext, c cVar) {
        this.mPageContext = tbPageContext;
        this.jqF = cVar;
    }

    public void setData(ArrayList<? extends com.baidu.tbadk.mvc.b.a> arrayList) {
        if (arrayList != null) {
            this.air.clear();
            this.air.addAll(arrayList);
            notifyDataSetChanged();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new b(this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.official_bar_feed_header_item, (ViewGroup) null));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (this.air != null && this.air.size() > 0) {
            com.baidu.tbadk.mvc.b.a aVar = this.air.get(i);
            if ((viewHolder instanceof b) && (aVar instanceof a)) {
                ((b) viewHolder).b(aVar);
            }
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return i;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.air == null) {
            return 0;
        }
        return this.air.size();
    }

    /* loaded from: classes25.dex */
    class b extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView iEZ;
        private BarImageView jqH;
        private View jqI;
        private a jqJ;

        b(View view) {
            super(view);
            this.jqH = (BarImageView) view.findViewById(R.id.official_bar_image);
            this.iEZ = (TextView) view.findViewById(R.id.official_bar_name);
            this.jqI = view.findViewById(R.id.official_bar_feed_red_dot);
            this.jqH.setShowOval(true);
            this.jqH.setPlaceHolder(2);
            this.jqH.setShowOuterBorder(false);
            this.jqH.setShowInnerBorder(true);
            this.jqH.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
        }

        void b(com.baidu.tbadk.mvc.b.a aVar) {
            this.jqJ = (a) aVar;
            ap.setViewTextColor(this.iEZ, R.color.cp_cont_b);
            ap.setBackgroundResource(this.jqI, R.drawable.icon_official_bar_red_dot);
            this.jqH.setStrokeColorResId(R.color.cp_border_a);
            this.jqH.startLoad(this.jqJ.cFM(), 10, false);
            if (at.getChineseAndEnglishLength(this.jqJ.czO()) <= 10) {
                this.iEZ.setText(this.jqJ.czO());
            } else {
                this.iEZ.setText(at.cutChineseAndEnglishWithSuffix(this.jqJ.czO(), 8, StringHelper.STRING_MORE));
            }
            this.jqH.setOnClickListener(this);
            if (this.jqJ.getUnReadCount() > 0 && (this.jqJ.cFN() <= 0 || System.currentTimeMillis() - this.jqJ.cFN() < 864000000)) {
                this.jqI.setVisibility(0);
            } else {
                this.jqI.setVisibility(8);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.jqI.setVisibility(8);
            if (d.this.jqF != null) {
                d.this.jqF.a(view, this.jqJ, getAdapterPosition(), getItemId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes25.dex */
    public static class a implements com.baidu.tbadk.mvc.b.a {
        private long cra;
        private long groupId;
        private String iPO;
        private String jqG;
        private int unReadCount;
        private int userType;

        String cFM() {
            return this.jqG;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String czO() {
            return this.iPO;
        }

        int getUnReadCount() {
            return this.unReadCount;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void KA(String str) {
            this.jqG = str;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void KB(String str) {
            this.iPO = str;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void setUnReadCount(int i) {
            this.unReadCount = i;
        }

        public void setGroupId(long j) {
            this.groupId = j;
        }

        public void setUserType(int i) {
            this.userType = i;
        }

        public long getGroupId() {
            return this.groupId;
        }

        public long cFN() {
            return this.cra;
        }

        public void fp(long j) {
            this.cra = j;
        }
    }
}
