package com.baidu.tieba.ala.a;

import android.animation.FloatEvaluator;
/* loaded from: classes10.dex */
public class a extends FloatEvaluator {
    private float aZv = 0.6818182f;

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.animation.TypeEvaluator
    public Float evaluate(float f, Number number, Number number2) {
        return f <= this.aZv ? Float.valueOf((f / this.aZv) * 1.3f) : Float.valueOf(1.3f - ((0.3f * (f - this.aZv)) / (1.0f - this.aZv)));
    }
}
