package com.baidu.tieba.barselect;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import d.b.i0.v.b.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class CandidateSearchAdapter extends RecyclerView.Adapter<CandidateSearchItemHolder> {

    /* renamed from: a  reason: collision with root package name */
    public List<a> f14786a = new ArrayList();

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: c */
    public void onBindViewHolder(CandidateSearchItemHolder candidateSearchItemHolder, int i) {
        if (candidateSearchItemHolder == null || ListUtils.isEmpty(this.f14786a)) {
            return;
        }
        candidateSearchItemHolder.g(this.f14786a.get(i));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: d */
    public CandidateSearchItemHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new CandidateSearchItemHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.view_candidate_item, (ViewGroup) null));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f14786a.size();
    }

    public void setData(List<a> list) {
        this.f14786a.clear();
        this.f14786a.addAll(list);
        notifyDataSetChanged();
    }
}
