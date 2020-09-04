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
/* loaded from: classes20.dex */
public class d extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<com.baidu.tbadk.mvc.b.a> ahW = new ArrayList<>();
    private c jhZ;
    private TbPageContext<?> mPageContext;

    /* loaded from: classes20.dex */
    public interface c {
        void a(View view, Object obj, int i, long j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(TbPageContext<?> tbPageContext, c cVar) {
        this.mPageContext = tbPageContext;
        this.jhZ = cVar;
    }

    public void setData(ArrayList<? extends com.baidu.tbadk.mvc.b.a> arrayList) {
        if (arrayList != null) {
            this.ahW.clear();
            this.ahW.addAll(arrayList);
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
        if (this.ahW != null && this.ahW.size() > 0) {
            com.baidu.tbadk.mvc.b.a aVar = this.ahW.get(i);
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
        if (this.ahW == null) {
            return 0;
        }
        return this.ahW.size();
    }

    /* loaded from: classes20.dex */
    class b extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView ixD;
        private BarImageView jic;
        private View jie;
        private a jif;

        b(View view) {
            super(view);
            this.jic = (BarImageView) view.findViewById(R.id.official_bar_image);
            this.ixD = (TextView) view.findViewById(R.id.official_bar_name);
            this.jie = view.findViewById(R.id.official_bar_feed_red_dot);
            this.jic.setShowOval(true);
            this.jic.setPlaceHolder(2);
            this.jic.setShowOuterBorder(false);
            this.jic.setShowInnerBorder(true);
            this.jic.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
        }

        void b(com.baidu.tbadk.mvc.b.a aVar) {
            this.jif = (a) aVar;
            ap.setViewTextColor(this.ixD, R.color.cp_cont_b);
            ap.setBackgroundResource(this.jie, R.drawable.icon_official_bar_red_dot);
            this.jic.setStrokeColorResId(R.color.cp_border_a);
            this.jic.startLoad(this.jif.cCf(), 10, false);
            if (at.getChineseAndEnglishLength(this.jif.cCg()) <= 10) {
                this.ixD.setText(this.jif.cCg());
            } else {
                this.ixD.setText(at.cutChineseAndEnglishWithSuffix(this.jif.cCg(), 8, StringHelper.STRING_MORE));
            }
            this.jic.setOnClickListener(this);
            if (this.jif.getUnReadCount() > 0 && (this.jif.cCh() <= 0 || System.currentTimeMillis() - this.jif.cCh() < 864000000)) {
                this.jie.setVisibility(0);
            } else {
                this.jie.setVisibility(8);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.jie.setVisibility(8);
            if (d.this.jhZ != null) {
                d.this.jhZ.a(view, this.jif, getAdapterPosition(), getItemId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes20.dex */
    public static class a implements com.baidu.tbadk.mvc.b.a {
        private long coX;
        private long groupId;
        private String jia;
        private String jib;
        private int unReadCount;
        private int userType;

        String cCf() {
            return this.jia;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String cCg() {
            return this.jib;
        }

        int getUnReadCount() {
            return this.unReadCount;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void JY(String str) {
            this.jia = str;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void JZ(String str) {
            this.jib = str;
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

        public long cCh() {
            return this.coX;
        }

        public void fb(long j) {
            this.coX = j;
        }
    }
}
